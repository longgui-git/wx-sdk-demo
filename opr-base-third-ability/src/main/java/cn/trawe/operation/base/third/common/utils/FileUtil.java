package cn.trawe.operation.base.third.common.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @ClassName FileUtil
 * @Author sunchen1
 * @Date 2019/1/21 16:23
 */
public class FileUtil {
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		} else {
			if (file.isFile())
				return deleteFile(fileName);
			else
				return deleteDirectory(fileName);
		}
	}

	/**
	 * 删除单个文件
	 *
	 * @param fileName 要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	/**
	 * 删除目录及目录下的文件
	 *
	 * @param dir 要删除的目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			System.out.println("删除目录失败：" + dir + "不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹中的所有文件包括子目录
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// 删除子目录
			else if (files[i].isDirectory()) {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			System.out.println("删除目录失败！");
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将图片字节数组写入服务器文件中
	 * 
	 * @param image
	 * @param fileName
	 * @return
	 */
	public static String saveFile(byte[] image, String fileName) {
		try {
			File file = new File(fileName);
			if (!file.exists() || !file.isFile()) {
				File fileParent = file.getParentFile();
				if (!fileParent.exists()) {
					fileParent.mkdirs();
				}
				file.createNewFile();
			} else if (file.isFile()) {
				file.delete();
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file, true);
			out.write(image);
			out.close();
			return fileName;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 图片到byte数组
	 * 
	 * @param path
	 * @return
	 */
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return data;
	}

	/**
	 * Java拼接多张图片
	 * 
	 * @param imgs
	 * @param type
	 * @param dst_pic
	 * @return
	 */
	public static boolean merge(String[] imgs, String type, String dst_pic) {
		// 获取需要拼接的图片长度
		int len = imgs.length;
		// 判断长度是否大于0
		if (len < 1) {
			return false;
		}
		File[] src = new File[len];
		BufferedImage[] images = new BufferedImage[len];
		int[][] ImageArrays = new int[len][];
		for (int i = 0; i < len; i++) {
			try {
				src[i] = new File(imgs[i]);
				images[i] = ImageIO.read(src[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			int width = images[i].getWidth();
			int height = images[i].getHeight();
			// 从图片中读取RGB 像素
			ImageArrays[i] = new int[width * height];
			ImageArrays[i] = images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);
		}

		int dst_height = 0;
		int dst_width = images[0].getWidth();
		// 合成图片像素
		for (int i = 0; i < images.length; i++) {
			dst_width = dst_width > images[i].getWidth() ? dst_width : images[i].getWidth();
			dst_height += images[i].getHeight();
		}
		// 合成后的图片
		if (dst_height < 1) {
			return false;
		}
		// 生成新图片   
		try {
			BufferedImage ImageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TYPE_INT_RGB);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				ImageNew.setRGB(0, height_i, images[i].getWidth(), images[i].getHeight(), ImageArrays[i], 0,
						images[i].getWidth());
				height_i += images[i].getHeight();
			}
			File outFile = new File(dst_pic);
			if (!outFile.exists() || !outFile.isFile()) {
				File fileParent = outFile.getParentFile();
				if (!fileParent.exists()) {
					fileParent.mkdirs();
				}
				outFile.createNewFile();
			}
			ImageIO.write(ImageNew, type, outFile);// 写图片 ，输出到硬盘 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 将文件转base64字符串
	 * 
	 * @param path
	 * @return
	 */
	public static String fileToBase64(String path) {
		String base64 = null;
		InputStream in = null;
		try {
			File file = new File(path);
			in = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			in.read(bytes);
			base64 = Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return base64;
	}

	/**
	 * base64转文件
	 * 
	 * @param base64
	 * @param filePath
	 */
	public static void base64ToFile(String base64, String filePath) {
		try {
			Files.write(Paths.get(filePath), Base64.getDecoder().decode(base64), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图片压缩
	 * 
	 * @param imageByte
	 * @param ppi
	 * @return
	 * @throws IOException 
	 */
	public static byte[] compressImage(byte[] imageByte, int ppi) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream byteInput = new ByteArrayInputStream(imageByte);
		Thumbnails.of(byteInput).size(ppi, ppi).outputFormat("jpg").toOutputStream(out);
		return out.toByteArray();
	}
	
}
