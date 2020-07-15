package com.example.quanlynhahang.ui.tools;

import com.example.quanlynhahang.Database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DanhSachThucDon {
    ResultSet resultSet;
    ConnectionDB connectionDB=new ConnectionDB();
    Connection connection;
    final ArrayList dstongsl= new ArrayList();
    final ArrayList dssoluong1= new ArrayList();
    final ArrayList dsmagoimon= new ArrayList();
    final ArrayList dstenmon=new ArrayList();
    final ArrayList dssoluong= new ArrayList();
    final ArrayList dsdongia=new ArrayList();
    final ArrayList dsmamon= new ArrayList();
    final ArrayList dshinhanh= new ArrayList();
    final ArrayList dsthanhtien= new ArrayList();
    final ArrayList dstrangthai= new ArrayList();
    public ArrayList KiemTraSL(String MaBan,String MaMon,String TrangThai)
    {
        try {
            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select top(1) SoLuong from TRANGTHAI where MaBan='"+MaBan+"' AND MaMon='"+MaMon+"' AND TrangThai=N'"+TrangThai+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dssoluong1.add(resultSet.getString("SoLuong"));
            }
        }
        catch (Exception ex)
        {

        }
        return dssoluong1;
    }
    public ArrayList getDstrangthai1(String MaBan,String MaMon,String TrangThai)
    {
        try {
            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from TRANGTHAI where MaBan='"+MaBan+"' AND MaMon='"+MaMon+"' AND TrangThai=N'"+TrangThai+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dstrangthai.add(resultSet.getString("SoLuong"));
            }
        }
        catch (Exception ex)
        {

        }
        return dstrangthai;
    }
    public ArrayList KiemTraTT(String MaBan,String MaMon,String TrangThai)
    {
        try {
            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select SUM(SoLuong) as TongSL from TRANGTHAI where MaBan='"+MaBan+"' AND MaMon='"+MaMon+"' AND TrangThai=N'"+TrangThai+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dstongsl.add(resultSet.getString("TongSL"));
            }
        }
        catch (Exception ex)
        {

        }
        return dstongsl;
    }
    public void UpdateTrangThai(String MaMon,int SoLuong,String MaBan,String TrangThai)
    {
        try {
            PreparedStatement statement1=connection.prepareStatement("update TOP(1) TRANGTHAI set SoLuong=(SoLuong-'"+SoLuong+"') where MaMon='"+MaMon+"' AND MaBan='"+MaBan+"' AND TrangThai=N'"+TrangThai+"'");
            resultSet=statement1.executeQuery();
            statement1.executeUpdate();
        }
        catch (Exception ex)
        {

        }
    }
    public void DeleteTrangThai(String MaMon,String MaBan,String TrangThai)
    {
        try {
            PreparedStatement statement1=connection.prepareStatement("DELETE TOP(1) TRANGTHAI where MaMon='"+MaMon+"' AND MaBan='"+MaBan+"' AND TrangThai=N'"+TrangThai+"'");
            resultSet=statement1.executeQuery();
            statement1.executeUpdate();
        }
        catch (Exception ex)
        {

        }
    }
    public void DeleteGoiMon(String MaGoiMon)
    {
        try {
            PreparedStatement statement1=connection.prepareStatement("DELETE GOIMON where MaGoiMon='"+MaGoiMon+"' AND SoLuong='"+0+"'");
            resultSet=statement1.executeQuery();
            statement1.executeUpdate();
        }
        catch (Exception ex)
        {

        }
    }

    public void UpdateThucDon(String MaGoiMon,String SoLuong)
    {
        dstongsl.clear();
        dsmagoimon.clear();
        dsthanhtien.clear();
        dsdongia.clear();
        dssoluong.clear();
        dstenmon.clear();
        try {
            PreparedStatement statement1=connection.prepareStatement("update GOIMON set SoLuong=N'"+SoLuong+"' where MaGoiMon='"+MaGoiMon+"'");
            resultSet=statement1.executeQuery();
            statement1.executeUpdate();
        }
        catch (Exception ex)
        {

        }
    }
    public ArrayList getMaGoiMon(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dsmagoimon.add(resultSet.getString("MaGoiMon"));
            }
        }
        catch (Exception ex)
        {

        }
        return dsmagoimon;
    }
    public ArrayList getMaMon(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dsmamon.add(resultSet.getString("MaMon"));
            }
        }
        catch (Exception ex)
        {

        }
        return dsmamon;
    }
    public ArrayList getTenMon(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dstenmon.add(resultSet.getString("TenMon"));
            }
        }
        catch (Exception ex)
        {

        }
        return dstenmon;
    }
    public ArrayList getSoLuong(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dssoluong.add(resultSet.getString("SoLuong"));
            }
        }
        catch (Exception ex)
        {

        }
        return dssoluong;
    }
    public ArrayList getHinhAnh(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select MONAN.HinhAnh from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dshinhanh.add(resultSet.getString("HinhAnh"));
            }
        }
        catch (Exception ex)
        {

        }
        return dshinhanh;
    }
    public ArrayList getDonGia(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select MONAN.DonGia from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dsdongia.add(resultSet.getString("DonGia"));
            }
        }
        catch (Exception ex)
        {

        }
        return dsdongia;
    }
    public ArrayList getThanhTien(String MaBan)
    {
        try {

            connection=connectionDB.connections();
            PreparedStatement statement=connection.prepareStatement("select * from GOIMON,MONAN,DANHSACHBAN where DANHSACHBAN.MaBan=GOIMON.MaBan and MONAN.MaMon=GOIMON.MaMon and GOIMON.MaBan='"+MaBan+"'");
            resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                dsthanhtien.add(resultSet.getString("ThanhTien"));
            }
        }
        catch (Exception ex)
        {

        }
        return dsthanhtien;
    }
}

