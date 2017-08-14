package io.github.lukas2005.speechrecognition.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Utils {

	/**
	 * Play Wav file (may not work for some wav fies and that does not mean they are corrupted)
	 * @param .wav (wave) File
	 */
	public static void playWav(File file) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
			audioIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Items in the list will get separated by space and returned as string
	 * @param list
	 * @return String made out of this list
	 */
	public static String listIntoString(List<String> list) {
		String endString = "";
		for (String s : list) {
			endString += s + " ";
		}
		
		return endString.substring(0, endString.length()-1);
	}
	
	/**
	 * Check if running on arm device (ive noticed some ffmpeg issues on arm)
	 */
	public static boolean isOnARM() {
		return System.getProperty("os.arch").contains("arm") ? true : false;
	}
	
}
