package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.pojo.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface StockMapper extends BaseMapper<Stock> {
    @Update("update tb_stock set stock = stock - #{num} where sku_id = #{id} and stock >= #{num}")
    int deceaseStock(@Param("num") Integer num,@Param("id") Long id);
}
