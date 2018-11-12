package com.baizhi.dao;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

public interface GuruDao  extends BaseDao<Guru>{
    void headPicUpload(@Param("id") String id,@Param("headPic") String deadPic);

}
