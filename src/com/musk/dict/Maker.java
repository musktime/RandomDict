package com.musk.dict;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Maker {
	static final String[] seeds = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	static final String filePath = "./dictionary.txt";

	public static void main(String[] args) {
		try {
			// 准备文件
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);

			int max = seeds.length - 1;
			Random random = new Random();
			int index = 0;
			for (int i = 0; i < seeds.length; i++) {
				// [0,seeds.length-1]
				index = random.nextInt(max) % (max + 1) + 0;
				fos.write(seeds[index].getBytes(), 0, seeds[index].length());
				if (i < seeds.length - 1)
					fos.write("\n".getBytes(), 0, "\n".length());
			}
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
