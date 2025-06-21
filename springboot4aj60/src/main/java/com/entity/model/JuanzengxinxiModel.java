package com.entity.model;

import com.entity.JuanzengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 捐赠信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-04 10:58:06
 */
public class JuanzengxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品名称
	 */
	
	private String shangpinmingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 捐赠数量
	 */
	
	private Integer juanzengshuliang;
		
	/**
	 * 捐赠时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date juanzengshijian;
		
	/**
	 * 捐赠地址
	 */
	
	private String juanzengdizhi;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
				
	
	/**
	 * 设置：商品名称
	 */
	 
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：捐赠数量
	 */
	 
	public void setJuanzengshuliang(Integer juanzengshuliang) {
		this.juanzengshuliang = juanzengshuliang;
	}
	
	/**
	 * 获取：捐赠数量
	 */
	public Integer getJuanzengshuliang() {
		return juanzengshuliang;
	}
				
	
	/**
	 * 设置：捐赠时间
	 */
	 
	public void setJuanzengshijian(Date juanzengshijian) {
		this.juanzengshijian = juanzengshijian;
	}
	
	/**
	 * 获取：捐赠时间
	 */
	public Date getJuanzengshijian() {
		return juanzengshijian;
	}
				
	
	/**
	 * 设置：捐赠地址
	 */
	 
	public void setJuanzengdizhi(String juanzengdizhi) {
		this.juanzengdizhi = juanzengdizhi;
	}
	
	/**
	 * 获取：捐赠地址
	 */
	public String getJuanzengdizhi() {
		return juanzengdizhi;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
			
}
