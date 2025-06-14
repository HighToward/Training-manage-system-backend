package com.company.training.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 图片生成工具类
 * 用于生成包含问题标题的封面图片
 */
public class ImageGeneratorUtil {
    
    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 400;
    private static final Color BACKGROUND_COLOR = new Color(245, 247, 250);
    private static final Color TEXT_COLOR = new Color(51, 51, 51);
    private static final Color ACCENT_COLOR = new Color(64, 158, 255);
    private static final String FONT_NAME = "Microsoft YaHei";
    
    /**
     * 生成包含标题的图片
     * @param title 问题标题
     * @param uploadDir 上传目录
     * @return 生成的图片文件名
     */
    public static String generateTitleImage(String title, String uploadDir) {
        try {
            // 创建图片
            BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            
            // 设置抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            // 填充背景
            g2d.setColor(BACKGROUND_COLOR);
            g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
            
            // 绘制装饰性元素
            drawDecorations(g2d);
            
            // 绘制标题
            drawTitle(g2d, title);
            
            g2d.dispose();
            
            // 保存图片
            String fileName = "title_" + UUID.randomUUID().toString() + ".png";
            File outputFile = new File(uploadDir, fileName);
            
            // 确保目录存在
            outputFile.getParentFile().mkdirs();
            
            ImageIO.write(image, "PNG", outputFile);
            
            return fileName;
            
        } catch (IOException e) {
            throw new RuntimeException("生成标题图片失败", e);
        }
    }
    
    /**
     * 绘制装饰性元素
     */
    private static void drawDecorations(Graphics2D g2d) {
        // 绘制左上角装饰圆
        g2d.setColor(new Color(ACCENT_COLOR.getRed(), ACCENT_COLOR.getGreen(), ACCENT_COLOR.getBlue(), 30));
        g2d.fillOval(-50, -50, 200, 200);
        
        // 绘制右下角装饰圆
        g2d.setColor(new Color(ACCENT_COLOR.getRed(), ACCENT_COLOR.getGreen(), ACCENT_COLOR.getBlue(), 20));
        g2d.fillOval(IMAGE_WIDTH - 150, IMAGE_HEIGHT - 150, 200, 200);
        
        // 绘制顶部装饰线
        g2d.setColor(ACCENT_COLOR);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(50, 50, IMAGE_WIDTH - 50, 50);
    }
    
    /**
     * 绘制标题文本
     */
    private static void drawTitle(Graphics2D g2d, String title) {
        if (title == null || title.trim().isEmpty()) {
            title = "问题详情";
        }
        
        // 设置字体
        Font titleFont = new Font(FONT_NAME, Font.BOLD, 36);
        g2d.setFont(titleFont);
        g2d.setColor(TEXT_COLOR);
        
        // 计算文本换行
        List<String> lines = wrapText(g2d, title, IMAGE_WIDTH - 100);
        
        // 计算总高度
        FontMetrics fm = g2d.getFontMetrics();
        int lineHeight = fm.getHeight();
        int totalHeight = lines.size() * lineHeight;
        
        // 计算起始Y坐标（居中）
        int startY = (IMAGE_HEIGHT - totalHeight) / 2 + fm.getAscent();
        
        // 绘制每一行
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int lineWidth = fm.stringWidth(line);
            int x = (IMAGE_WIDTH - lineWidth) / 2; // 水平居中
            int y = startY + i * lineHeight;
            
            g2d.drawString(line, x, y);
        }
        
        // 绘制副标题
        Font subtitleFont = new Font(FONT_NAME, Font.PLAIN, 18);
        g2d.setFont(subtitleFont);
        g2d.setColor(new Color(153, 153, 153));
        
        String subtitle = "问题讨论";
        FontMetrics subtitleFm = g2d.getFontMetrics();
        int subtitleWidth = subtitleFm.stringWidth(subtitle);
        int subtitleX = (IMAGE_WIDTH - subtitleWidth) / 2;
        int subtitleY = startY + lines.size() * lineHeight + 30;
        
        g2d.drawString(subtitle, subtitleX, subtitleY);
    }
    
    /**
     * 文本换行处理
     */
    private static List<String> wrapText(Graphics2D g2d, String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        FontMetrics fm = g2d.getFontMetrics();
        
        String[] words = text.split("");
        StringBuilder currentLine = new StringBuilder();
        
        for (String word : words) {
            String testLine = currentLine.toString() + word;
            int testWidth = fm.stringWidth(testLine);
            
            if (testWidth <= maxWidth) {
                currentLine.append(word);
            } else {
                if (currentLine.length() > 0) {
                    lines.add(currentLine.toString());
                    currentLine = new StringBuilder(word);
                } else {
                    lines.add(word);
                }
            }
        }
        
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }
        
        // 限制最大行数
        if (lines.size() > 4) {
            lines = lines.subList(0, 3);
            String lastLine = lines.get(2);
            if (lastLine.length() > 10) {
                lines.set(2, lastLine.substring(0, 10) + "...");
            } else {
                lines.set(2, lastLine + "...");
            }
        }
        
        return lines;
    }
}