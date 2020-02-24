package com.blogger.bloggerservice.utils;

import com.blogger.bloggerservice.model.Article;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author admin
 */
public class FileUtils {

    private FileUtils() {
    }

    /**
     * 替换掉系统的保留字符串
     * @param title
     * @return
     */
    private static String replaceTitle (String title) {
        String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        //这里是将特殊字符换为aa字符串," "代表直接去掉
        StringBuffer sb = new StringBuffer(title);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");

        StringBuffer out = new StringBuffer(rs);

        return out.reverse().toString();
    }
    /**
     * 文章生成网页
     * @param articleList
     * @param htmlPath
     * @return
     */
    public static String generateHtml (List<Article> articleList, String htmlPath) {
        String folderPath = htmlPath + UUID.randomUUID() + "/";
        File folder = new File(folderPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        for (Article article : articleList) {
            try {
                String saveHtmlFile = folderPath + article.getArticleTitle() + ".html";
                File file =new File(saveHtmlFile);
                if(!file.exists()){
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(saveHtmlFile), "UTF-8"));
                bufferedWriter.write(article.getArticleContent());
                bufferedWriter.newLine();// 换行
                /*
                 * * 刷新该流的缓冲。 关键的一行代码。如果没有加这行代码。数据只是保存在缓冲区中。没有写进文件。 加了这行才能将数据写入目的地。
                 * *
                 */
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return folderPath;
    }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return
     * @throws IOException
     */
    public static void fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            File zipFile = new File(zipFilePath);
            if (!zipFile.exists()) {
                zipFile.mkdirs();
            }
            File[] sourceFiles = sourceFile.listFiles();
            if (null == sourceFiles || sourceFiles.length < 1) {
                //无文件
            } else {
                fos = new FileOutputStream(zipFile + "/" + fileName);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                byte[] bufs = new byte[1024 * 10];
                for (int i = 0; i < sourceFiles.length; i++) {
                    //创建ZIP实体，并添加进压缩包
                    ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                    zos.putNextEntry(zipEntry);

                    //读取待压缩的文件并写进压缩包里
                    fis = new FileInputStream(sourceFiles[i]);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                    }
                    if (null != bis) {
                        bis.close();
                    }
                }
                if (null != zos) {
                    zos.closeEntry();
                    zos.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                if (null != fis) {
                    fis.close();
                }
                if (null != fos) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 删除文件夹
     * @param folder
     */
    public static void deleteFolder(String folder) {
        File files = new File(folder);
        FileUtils.deleteFileAll(files);
    }

    /**
     * 删除文件下所有文件夹和文件
     * file：文件名
     * */
    public static void deleteFileAll(File file) {
        if (file.exists()) {
            File files[] = file.listFiles();
            int len = files.length;
            for (int i = 0; i < len; i++) {
                if (files[i].isDirectory()) {
                    deleteFileAll(files[i]);
                } else {
                    files[i].delete();
                }
            }
            file.delete();
        }
    }
}
