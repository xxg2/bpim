package com.bpim.common;

import java.util.HashSet;
import java.util.Set;

/**
 * author Delgado
 */
public class ExcelTitleUtil {
	public static Set<String> userProjectDataTitleSet = new HashSet<String>();
	public static Set<String> userCustomDataTitleSet = new HashSet<String>();
	public static Set<String> governmentQuotaTitleSet = new HashSet<String>();
	public static Set<String> peopleUnitSet = new HashSet<String>();
	public static Set<String> materialUnitSet = new HashSet<String>();
	public static Set<String> machineUnitSet = new HashSet<String>();
	
	public static String recordNum = "编号";
	public static String recordClasses = "类别";
	public static String recordName = "名称";
	public static String recordUnit = "单位";
	public static String recordPrice = "单价";
	public static String recordGross = "工程量";
	public static String recordTotalPrice = "合价";
	
	public static Set<String> subType = new HashSet<String>();
	public static String people = "人工";
	public static String material = "材料";
	public static String machine = "机械";
	
	public static String recordCode = "编码";
	public static String recordModel = "规格";
	public static String recordAmount = "数量";
	public static String recordPercent = "百分比";
	public static String recordType = "类型";
	public static String recordGuideDate = "指导价日期";
	
	static {
		userProjectDataTitleSet.add(recordNum);
		userProjectDataTitleSet.add(recordClasses);
		userProjectDataTitleSet.add(recordName);
		userProjectDataTitleSet.add(recordUnit);
		userProjectDataTitleSet.add(recordPrice);
		userProjectDataTitleSet.add(recordGross);
		userProjectDataTitleSet.add(recordTotalPrice);
		
		subType.add(people);
		subType.add(material);
		subType.add(machine);
		
		userCustomDataTitleSet.add(recordCode);
		userCustomDataTitleSet.add(recordName);
		userCustomDataTitleSet.add(recordModel);
		userCustomDataTitleSet.add(recordUnit);
		userCustomDataTitleSet.add(recordPrice);
		userCustomDataTitleSet.add(recordAmount);
		userCustomDataTitleSet.add(recordTotalPrice);
		userCustomDataTitleSet.add(recordPercent);
		userCustomDataTitleSet.add(recordType);
		userCustomDataTitleSet.add(recordGuideDate);
		
		governmentQuotaTitleSet.add(recordNum);
		governmentQuotaTitleSet.add(recordName);
		governmentQuotaTitleSet.add(recordModel);
		governmentQuotaTitleSet.add(recordUnit);
		governmentQuotaTitleSet.add(recordAmount);
		governmentQuotaTitleSet.add(recordPrice);
		governmentQuotaTitleSet.add(recordTotalPrice);
		
		
		peopleUnitSet.add("工日");
		peopleUnitSet.add("组日");
		
		machineUnitSet.add("台班");
		machineUnitSet.add("台次");
		
		materialUnitSet.add("m2");
		materialUnitSet.add("百根");
		materialUnitSet.add("m3");
		materialUnitSet.add("kg");
		materialUnitSet.add("t");
		materialUnitSet.add("只");
		materialUnitSet.add("m");
		materialUnitSet.add("片");
		materialUnitSet.add("根");
		materialUnitSet.add("株");
		materialUnitSet.add("副");
		materialUnitSet.add("套");
		materialUnitSet.add("块");
		materialUnitSet.add("个");
		materialUnitSet.add("樘");
		materialUnitSet.add("把");
		materialUnitSet.add("百个");
		materialUnitSet.add("支");
		materialUnitSet.add("百套");
		materialUnitSet.add("组");
		materialUnitSet.add("张");
		materialUnitSet.add("瓶");
		materialUnitSet.add("盒");
		materialUnitSet.add("百只");
		materialUnitSet.add("吨");
		materialUnitSet.add("千块");
		materialUnitSet.add("g");
		materialUnitSet.add("卷");
		materialUnitSet.add("副");
		materialUnitSet.add("Kg");
		materialUnitSet.add("平方米×天");
		materialUnitSet.add("块·天");
		materialUnitSet.add("付");
		materialUnitSet.add("度");
		materialUnitSet.add("ml");
		materialUnitSet.add("件");
	}
}
