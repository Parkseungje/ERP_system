package kr.happyjob.study.common.comnUtils;

import java.io.File;

public class AbsolutePath {
	
	private static AbsolutePath instance = new AbsolutePath();
	private static String rootPath = File.listRoots()[0].getAbsolutePath();
	
	private AbsolutePath() {
	}
	public static AbsolutePath getInstance() {
		return instance;
	}
	
	public static String getRootPath() {
		return rootPath;
	}
	public static void main(String[] args) {
		System.out.println(rootPath);
	}

}
