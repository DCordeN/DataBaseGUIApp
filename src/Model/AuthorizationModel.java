package Model;


public class AuthorizationModel {
    private String currLogin, currPass;
    private final String[] logins = {"stud01", "stud02", "stud03", "stud04", "stud05", "stud06", "stud07", "stud08", "stud09", "stud10", "stud11", "stud12", "stud13", "stud14", "stud15", "stud16"};
    private final String[] passwords = {"stud01", "stud02", "stud03", "stud04", "stud05", "stud06", "stud07", "stud08", "stud09", "stud10", "stud11", "stud12", "stud13", "stud14", "stud15", "stud16"};
    private int count = 3;
    
    public void setEnterData(String login, String pass){
        this.currLogin = login;
        this.currPass = pass;
    }
    

    
    public boolean isCorrect(){                                //перенести в модель
        boolean flag = false;
        String[] correctLogins = logins;
        String[] correctPasswords = passwords;
        
        for(int i = 0; i < correctLogins.length; i++)
            if(correctLogins[i].equals(currLogin) && correctPasswords[i].equals(currPass))
                flag = true;
        
        return flag;
    }
    
    public Boolean isOver(){                                                                
        return getCount() == 0 ? true : false;                                  
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(){
        this.count = count-1;         
    }  
}
