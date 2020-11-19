package cn.makn.validate.dao;

import cn.makn.validate.entity.VDcit;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0
 * @description
 * @Auther: makn
 * @Date: Created by 2020/10/31 9:54
 */
@Repository
public interface VDcitDao {
    VDcit selectByPrimaryKey(VDcit vDcit);
}
