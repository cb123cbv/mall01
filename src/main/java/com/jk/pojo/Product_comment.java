package com.jk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Product_comment {

   private Integer id;//(编号)           PKInteger
   private Integer yh_id;//(用户id)      Integer
   private String plnr;//(评论内容)     String(1000)
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date plshj;//(评论时间)    Date
   private Integer hpjb;//(好评级别)     Integer
   private Integer sku_id;//(skuid)      Integer
   private String sku_mch;//(sku名称)   String(100)
   private Integer shp_id;//(商品id)     Integer
   private String shp_mch;//(商品名称)  String(100)
   private Integer dd_id;//(订单id)      Integer
   private Integer state;//状态 0:提交未审核  1:审核通过  2:审核拒绝


}
