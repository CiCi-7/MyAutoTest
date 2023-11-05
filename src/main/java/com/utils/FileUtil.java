package com.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/04/13:56
 * @Description:
 */
public class FileUtil {

    public static String convertPDFToText(String pdfFilePath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String text = pdfTextStripper.getText(document);
        document.close();
        return text;
    }

}
