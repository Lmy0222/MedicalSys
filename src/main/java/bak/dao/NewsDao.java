package bak.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import bak.domain.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsDao extends BaseMapper<News> {
}
