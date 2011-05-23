/*package com.easy;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

public class MenuUtils {
	private static Menus menus ;
	private static Menu menu;
	
    private static Menus getMenus(Context context) throws UnsupportedEncodingException{
		try {
			InputStream inputStream=context.getAssets().open("menu.xml");
			menus = MenuService.getServer(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
    
    private static Menu getMenu(String menuName){
    	Menu menu = null;
    	for(Menu tmp : menus.getMenuList()){
    		if(menuName.equalsIgnoreCase(tmp.getMenuName())){
    			menu = tmp;
    		}
    	}
    	return menu;
    }
//
//	public static void toMenu(Context context , String menuName) {
//		try {
//			if(null == menus){
//				menus = getMenus(context);
//			}
//			
//			
//			
//			if(menu == null || !menuName.equals(menu.getMenuName())){
//				menu = getMenu(menuName);
//			}
//			
//			if(menu != null ){
//				ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
//				ComponentName cn = am.getRunningTasks(1).get(0).topActivity;  
//				if(null != cn.getClassName() && cn.getClassName().equals(menu.getMenuClass())){
//					//将快捷菜单隐藏起来
//					return ;
//				}
//				
//				if(menu.isNeedLogin()){
//					FairyUI.switchToWnd(menu.getPos(),menu.getPos(), context);
//				}else {
//					FairyUI.switchToWnd(menu.getPos(),menu.getPosition(),null ,null, context);
//				}
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	}
}
*/