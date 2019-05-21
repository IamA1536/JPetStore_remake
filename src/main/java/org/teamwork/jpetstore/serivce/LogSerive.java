package org.teamwork.jpetstore.serivce;

import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.domain.extra.Log;
import org.teamwork.jpetstore.persistence.LogDAO;
import org.teamwork.jpetstore.persistence.impl.LogDAOImpl;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/14 15:19
 */
public class LogSerive {
    private LogDAO logDAO;

    public LogSerive(){
        logDAO = new LogDAOImpl();
    }

    public void InsertLog(Account account, String type) throws Exception {
        Log log = new Log(account, type);
        logDAO.InsertLog(log);
    }

}
