package service;

import entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;  
  

public interface UserService extends Remote {  
    public User getUserById(String id)throws RemoteException;
}  