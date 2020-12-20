package com.zking.ssm.util;


import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.print.DocFlavor;

/**
 * 用于shiro权限认证的密码工具类
 * 此时此刻用的是shiro的盐加密
 * 但是只用盐加密不做权限管理
 * @author Administrator ygm
 */
public class PasswordHelper {

    /**
     * 随机数生成器
     */
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 指定hash算法为MD5
     */
    private static final String hashAlgorithmName = "md5";

    /**
     * 指定散列次数为1024次，即加密1024次
     */
    private static final int hashIterations = 1024;

    /**
     * true指定Hash散列值使用Hex加密存. false表明hash散列值用用Base64-encoded存储
     */
    private static final boolean storedCredentialsHexEncoded = true;

    /**
     * 获得加密用的盐
     *
     * @return
     */
    public static String createSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    /**
     * 获得加密后的凭证
     *
     * @param credentials 凭证(即密码)
     * @param salt        盐
     * @return
     */
    public static String createCredentials(String credentials, String salt) {
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        return storedCredentialsHexEncoded ? simpleHash.toHex() : simpleHash.toBase64();
    }


    /**
     * 进行密码验证
     *
     * @param credentials        未加密的密码
     * @param salt               盐
     * @param encryptCredentials 加密后的密码
     * @return
     */
    public static boolean checkCredentials(String credentials, String salt, String encryptCredentials) {
        return encryptCredentials.equals(createCredentials(credentials, salt));
    }

    public static void main(String[] args) {
        //盐
        String salt = createSalt();
//      1     e2d15acca86178e3acb88d1114d52b0e
//      2    6dea1347ad029a3a3709b366cf86706a
        System.out.println(salt);
        System.out.println(salt.length());

        //凭证+盐加密后得到的密码
        String credentials = createCredentials("123456", salt);
//      1   6cc1a1f360058f2aaf0e7c8f37c0e6e0
//      2   002c30ba4ea83f659f1d430b6477ccb7
        System.out.println(credentials);
        System.out.println(credentials.length());

//      判断是否正确
        boolean b = checkCredentials("123456", salt, credentials);
        System.out.println(b);

        String sal = "e2d15acca86178e3acb88d1114d52b0e";
        String credential = "6cc1a1f360058f2aaf0e7c8f37c0e6e0";

        boolean b1 = checkCredentials("123456", sal, credential);
        System.out.println(b1);


    }
}
