package kladionica.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import kladionica.session.local.UserSessionBeanLocal;
import kladionica.session.remote.UserSessionBeanRemote;

/**
 * Session Bean implementation class UserSessionBean
 */
@Stateful
@LocalBean
public class UserSessionBean implements UserSessionBeanRemote, UserSessionBeanLocal {

    /**
     * Default constructor. 
     */
    public UserSessionBean() {
        // TODO Auto-generated constructor stub
    }

}
