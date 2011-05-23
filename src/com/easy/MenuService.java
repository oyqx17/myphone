package com.easy;


import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class MenuService {
    public static Menus getServer(InputStream inputStream) throws Exception {
        XmlPullParser xmlpull = Xml.newPullParser();
        xmlpull.setInput(inputStream, "utf-8");

        Menus menus = null;
        Menu menu = null;
        ArrayList<Menu> menuList = null;
        
        int eventCode = xmlpull.getEventType();
        while (eventCode != XmlPullParser.END_DOCUMENT) {
            switch (eventCode) {
            case XmlPullParser.START_DOCUMENT: {// 
                menus = new Menus();
                menuList = new ArrayList<Menu>();
                break;
            }
            case XmlPullParser.START_TAG: {
                if ("menu".equals(xmlpull.getName()) && menuList != null && menus != null) {
                    menu = new Menu();
                } else if ("menuName".equals(xmlpull.getName() )
                        && menuList != null && menus != null && menu != null) {
                    String menuNmae = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(menuNmae)) {
                        menu.setMenuName(menuNmae);
                    }
                } else if("menuClass".equals(xmlpull.getName())
                        && menuList != null && menus != null && menu != null){
                    String menuClass = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(menuClass)) {
                        menu.setMenuClass(menuClass);
                    }
                }  else if("pos".equals(xmlpull.getName())
                        && menuList != null && menus != null && menu != null){
                    String pos = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(pos)) {
                        menu.setPos(Integer.parseInt(pos));
                    }
                } else if("position".equals(xmlpull.getName())
                        && menuList != null && menus != null && menu != null){
                    String position = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(position)) {
                        menu.setPosition(Integer.parseInt(position));
                    }
                } else if("menu_id".equals(xmlpull.getName())
                        && menuList != null && menus != null && menu != null){
                    String menu_id = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(menu_id)) {
                        menu.setMenu_id(Integer.parseInt(menu_id));
                    }
                }else if("isneedlogin".equals(xmlpull.getName())
                        && menuList != null && menus != null && menu != null){
                    String isneedlogin = xmlpull.nextText().trim();
                    if (!"".equalsIgnoreCase(isneedlogin)) {
                        menu.setNeedLogin(Boolean.parseBoolean(isneedlogin));
                    }
                }
                
                break;
            }
            case XmlPullParser.END_TAG: {
                if("menu".equals(xmlpull.getName()) && menuList != null && menus != null && menu != null){
                    menuList.add(menu);
                    menu = null;
                }else if("menus".equals(xmlpull.getName()) && menuList != null && menus != null){
                    menus.setMenuList(menuList);
                }
                break;
            }
            }
            eventCode = xmlpull.next();
        }
        return menus;
    }
}

