package com.hx.config.md5;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/8 17:19
 *@功能:
 */

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Salt {
    public static String salt(){
        RandomNumberGenerator randomNumberGenerator =new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }
}
