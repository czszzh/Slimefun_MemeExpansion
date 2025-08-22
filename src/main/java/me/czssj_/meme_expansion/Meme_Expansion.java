package me.czssj_.meme_expansion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.annotation.Nonnull;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import me.czssj_.meme_expansion.setup.Meme_Expansion_setup;

public class Meme_Expansion extends JavaPlugin implements SlimefunAddon
{
    private static Meme_Expansion instance;
    private static final Logger LOGGER = Logger.getLogger("Meme_Expansion");

    @Override
    public void onEnable() 
    {
        instance = this;
        Config cfg = new Config(this);

        checkForDepends();

        if (cfg.getBoolean("options.auto-update")) 
        {
            checkForUpdates();
        }

        Meme_Expansion_setup.Material_setup(this);
        Meme_Expansion_setup.Item_setup(this);
        Meme_Expansion_setup.Machine_setup(this);
        Meme_Expansion_setup.Generator_setup(this);
        Meme_Expansion_setup.Armor_setup(this);
        Meme_Expansion_setup.Weapon_setup(this);
        Meme_Expansion_setup.Amulet_setup(this);
        Meme_Expansion_setup.Boss_setup(this);
        
        LOGGER.info("====================");
        LOGGER.info("|  Meme_Expansion  |");
        LOGGER.info("|      by sj_      |"); 
        LOGGER.info("====================");
    }

    @Override
    public void onDisable() 
    {
        LOGGER.info("Good Bye! ;)");
    }

    @Override
    public String getBugTrackerURL() 
    {
        return "https://github.com/czszzh/Slimefun_MemeExpansion/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() 
    {
        return this;
    }

    public static Meme_Expansion getInstance() 
    {
        return instance;
    }

    private void checkForDepends()
    {
        // 必需前置
        if (!getServer().getPluginManager().isPluginEnabled("FluffyMachines"))
        {
            LOGGER.warning("本插件需要 蓬松机器(FluffyMachines) 才能运行!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        else
        {
            LOGGER.info("前置 蓬松机器(FluffyMachines) 已加载");
        }
        
        if (!getServer().getPluginManager().isPluginEnabled("InfinityExpansion"))
        {
            LOGGER.warning("本插件需要 无尽贪婪(InfinityExpansion) 才能运行!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        else
        {
            LOGGER.info("前置 无尽贪婪(InfinityExpansion) 已加载");
        }
        
        if (!getServer().getPluginManager().isPluginEnabled("Slimefun"))
        {
            LOGGER.warning("粘液科技本体都没有还想玩这个附属插件?");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void checkForUpdates() 
    {
        configureSslContext();
        try 
        {
            String apiUrl = "https://api.github.com/repos/czszzh/Slimefun_MemeExpansion/releases/latest";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == 200) 
            {
                StringBuilder jsonResponse;
                try (Scanner scanner = new Scanner(connection.getInputStream())) 
                {
                    jsonResponse = new StringBuilder();
                    while (scanner.hasNext()) jsonResponse.append(scanner.nextLine());
                }

                JSONObject jsonObject = new JSONObject(jsonResponse.toString());
                String latestVersion = jsonObject.getString("tag_name");

                if (!getDescription().getVersion().equals(latestVersion)) 
                {
                    LOGGER.warning(String.format("发现新版本: %s", latestVersion));
                    // 打印下载链接
                    String downloadUrl = jsonObject.getJSONArray("assets").getJSONObject(0).getString("browser_download_url");
                    LOGGER.warning(String.format("下载链接: %s", downloadUrl));

                } 
                else 
                {
                    LOGGER.info(String.format("当前已经是最新版本: %s", latestVersion));
                }
            } 
            else 
            {
                LOGGER.warning(String.format("无法检查更新,GitHub API 返回了 %s", connection.getResponseCode()));
            }
        } 
        catch (IOException | JSONException e) 
        {
            LOGGER.severe(String.format("检查更新时发生错误: %s", e.getMessage()));
        }
    }

    //忽略ssl证书
    private void configureSslContext() 
    {
        try 
        {
            // 创建一个不进行验证的 TrustManager
            TrustManager[] trustAllCerts = new TrustManager[] 
            {
                new X509TrustManager() 
                {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() 
                    { 
                        return null; 
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            // 初始化 SSLContext
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
    
            // 设置默认的SSLSocketFactory
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    
            // 设置默认的主机名验证器，允许所有主机名
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } 
        catch (KeyManagementException | NoSuchAlgorithmException e) 
        {
            LOGGER.severe(String.format("配置 SSL 证书时发生错误: %s", e.getMessage()));
        }
    }
}