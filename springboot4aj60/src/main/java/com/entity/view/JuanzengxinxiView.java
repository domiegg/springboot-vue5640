package com.entity.view;

import com.entity.JuanzengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 捐赠信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-04 10:58:06
 */
@TableName("juanzengxinxi")
public class JuanzengxinxiView  extends JuanzengxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JuanzengxinxiView(){
	}
 
 	public JuanzengxinxiView(JuanzengxinxiEntity juanzengxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, juanzengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
