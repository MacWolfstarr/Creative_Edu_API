package com.example.edu_institute.Utill;

public class Response {


    private int Status;
    private Object Data;
    private String Message;


    public Response(int status, Object data, String message)
    {
        Status = status;
        Data = data;
        Message = message;
    }


    //region "Getters and Setters"

    public int getStatus()
    {
        return Status;
    }

    public void setStatus(int status)
    {
        Status = status;
    }

    public Object getData()
    {
        return Data;
    }

    public void setData(Object data)
    {
        Data = data;
    }

    public String getMessage()
    {
        return Message;
    }

    public void setMessage(String message)
    {
        Message = message;
    }


    public String toString()
    {
        return "Response \n{" +
                "\nStatus : " + Status +
                ",\nData : " + Data +
                ",\nMessage : '" + Message + '\'' +
                '}';
    }


}
