package org.teamwork.jpetstore.serivce;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.persistence.Mapper.AccountMapper;
import org.teamwork.jpetstore.persistence.SessionFactoryUtil;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/9 22:56
 */
public class AccountService {
    private SqlSessionFactory sqlSessionFactory;

    public AccountService() {
    }

    public Account getAccount(String username) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountByUsername(username);
    }

    public Account getAccount(Account account) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    public Account getAccount(String username, String password) throws Exception {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    public void updateAccount(Account account) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);
        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountMapper.updateSignon(account);
        }
    }
}
