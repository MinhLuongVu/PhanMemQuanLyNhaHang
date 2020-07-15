package com.example.quanlynhahang.ui.login;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.quanlynhahang.Database.ConnectionDB;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {

    final ArrayList HoTenNV=new ArrayList();
    ConnectionDB connectionDB=new ConnectionDB();
    ResultSet resultSet;
    Connection connection=connectionDB.connections();


/*
    public String Login(String TenDN,String MatKhau)
    {
        try {
            PreparedStatement statement1=connection.prepareStatement("select HoTenNV from NHANVIEN where TenDN='"+TenDN+"' and MatKhau='"+MatKhau+"'");
            resultSet=statement1.executeQuery();
            statement1.executeUpdate();
        }
        catch (Exception ex)
        {

        }
    }*/

    public ArrayList Login(String TenDN,String MatKhau)
    {
        try {
            MatKhau=encryptThisString(MatKhau);
            PreparedStatement statement1=connection.prepareStatement("select HoTenNV from NHANVIEN where TenDN='"+TenDN+"' and MatKhau='"+MatKhau+"'");
            resultSet=statement1.executeQuery();
            while (resultSet.next())
            {
                HoTenNV.add(resultSet.getString("HoTenNV"));
            }
        }
        catch (Exception ex)
        {

        }
        return HoTenNV;
    }
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    public static String encryptThisString(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}