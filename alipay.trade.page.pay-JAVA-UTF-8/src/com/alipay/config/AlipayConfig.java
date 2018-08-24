package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091800539904";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCH18XCwex+CsfjJcpTA/DPeRS+X3nF07zo3EB92kCeE7S+Jm81GiD3wDKM578B2DYg5mvgJyD3v07rRGDJqmqAVbVJ4VT+CASARIPtJipBEJmCSIZ6RYNRD3YUb/MmHn3vm98ZF+4eAB9vuL/jomLaGMO57bLpO1YZ3iw2YAKvzGtu/IVW94nlSH71eH9AI8votaUgj1j91rfyi5gxC3RAo6QXV+ZFWBNm0SNFBaI0KSIJaTfJGRvDf+WoSAYsQRcUdL+rcAPGeg85UYMCmwDVeGOQm4zwM0ChfOsxEf1Klpr3P2DVeWxgcCUK/iFVx1s4ATZCmImqFKFxMM5Q1hZHAgMBAAECggEANsy+xLCCfN5QgLvQAOlIDgpkaeAOOdYPEUk44wxWoO6GLWdH2X4u6oMoYVtj3JSiUWdjAUwHqqoMZjBxcylCSX9J4QH7zXbiifQZ3GNXDGRr6Pjk9xJvxRWdpuT6i9glKbIRsAfNUWDvTZyUHHp3sk/nNWxEjn4XX9wWreDRdKVF8zrR1oh2xmZCcLQ3bltViUtSiU7YgHOs2T2iF7csW/foWXLYLccc0PaJNSV7Bng2UUJuECvLmmguS7n1mof5Ynr8wMBiLQvX+tzpVKR5qxpX3cEzoLPjdYidttOB5khsI5/6tWj5YULT4pDp775FHro0A5Dnjqzxfh/FofxlsQKBgQDAIGwEy4Flyi0phHVS9roqImhGkeXalMV7KOySetQjdaKFIdFDxhxRwl4kd3XAdnJ85uVYLA1Nz9l79O5Yrck38lV4CAXO5z76k1hvXW38stKLyMHJ+Vwt3kuv5OUOF+MOX+6GBP8/oo10WyZLir6qT6qEQn6ctsr5BzqRvbJPawKBgQC1ASGo6PBFJ8gSJ4f78YqYEO5DptZAJ8NkhJOVWy7t6w15MRqObYA/mTkgvELwUv6VFeGXqaegQ+e1XVzNWLBr3LD1c4fsqVW36rHJ03tjOg+wO/WOz/UvmqiNoMsb/mjteqIwYSoHxQeSSbzLlLDWlZMcObnNCgTFafgPM9HXlQKBgQCvzDrqvEefmzpt1d0A1/AKY8dkY1WeBykYA59MfQWlmJroFMSFrj31ddNsrL5bKEakESZj4pMd0wUezkRVclc/UQdxuG2QH7pZz/9Ij4X3hqzu6PihVgFJmzFINjp9BdBmM9NuYB4q3RNwF4NX9hF2h0TwlmOCBCR/b2ThPGFvFwKBgCTtzStEEzlYy3YAwLrDZg5ubd45nL7MHg5VCjNPvjxmV4JhZVSnvKG9Ji2qm1Gi7TQHmdYyk/Obxxt2p+dxb9Uh2qzJXHMJfWafqJRP5H2zK9497XSssw56VGdI5geZGVlSSuLqAARDy66qAq3acVXmgHQixuixYZXRb/3SCb8dAoGBAKLtuk9KZXTXsvpCaKB+a62s7/XhC8TqcoxQ4fqIi77ytHo0pYEUPbYCBrHT8yMnvwV48nqfblAKKvTcqagyqzTzRHp4X0VeWkJICa/LwvDJJanfXh9BLQvjl86gq/pwtpd0duHBhkWVGUX2oVPiwxiaponSpzCoxFU4BoJDymQQ";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlRpXfr/UV9ylLIA3Uzy1eLIgj+PG360T5xp077mH+JzvfGxg2DYPBJHZAaNfedWkroDAt41ATqS4Gwc5mZddX0GIGLPpJZEZbBmar3hLVxmGqqkF3I5ak95IR8jCYf/CAMhxp2gyn/yCAx2CT7f4EKaiPgJxv+eRuxvMLlREKHGmTLve/JpzaJdUmZZLhHGDyMvkf+b8mYfH1+gfkWD/NVJBAf3iK8hSFzmKS15pcYd+8sYlyB8nPAcaquZT7x0mO8Wobh4A44/53BPEqqsYL+zu6j3Zc3dVnaQ1QMqIKAe9FwhtAj0OCf/0t0z2F+YyTxIufVdjQX1XQT57MYMPJwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

