package com.mom.watch;

public class WatchMain {
	public static void main(String[] args){
		System.out.println(WatchMain.class.getPackage().getName());
	}
	public static String pakageName(){
		return WatchMain.class.getPackage().getName();
	}
}
