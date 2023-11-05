package com.utils;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/04/02:36
 * @Description:
 */
public class ImageUtil {

    public static String recognizeCaptcha(String base64Image) {
        Tesseract tesseract = new Tesseract();
        String captchaText = null;
        try {
            captchaText = tesseract.doOCR(new File(base64Image));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return captchaText;
    }

    public static int performArithmeticOperation(String captchaText) {
        // 解析 captchaText 中的数字，执行算术操作
        // 这部分根据您的验证码图像和算术操作逻辑来实现
        // 示例：将两个数字相加
        String[] numbers = captchaText.split("\\+");
        int num1 = Integer.parseInt(numbers[0].trim());
        int num2 = Integer.parseInt(numbers[1].trim());
        return num1 + num2;
    }
}
