package cn.trawe.operation.base.third.dbaccess.service.impl;

import cn.trawe.operation.base.third.dbaccess.domain.User;
import cn.trawe.operation.base.third.dbaccess.mapper.UserMapper;
import cn.trawe.operation.base.third.dbaccess.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
