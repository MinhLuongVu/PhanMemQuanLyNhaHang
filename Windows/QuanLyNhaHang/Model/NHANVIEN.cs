//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace QuanLyNhaHang.Model
{
    using System;
    using System.Collections.Generic;
    
    public partial class NHANVIEN
    {
        public int MaNV { get; set; }
        public string HoTenNV { get; set; }
        public string DiaChi { get; set; }
        public string SDT { get; set; }
        public string HinhAnhNV { get; set; }
        public string TenDN { get; set; }
        public string MatKhau { get; set; }
        public string HeThong { get; set; }
        public Nullable<int> MaChucVu { get; set; }
    
        public virtual CHUCVU CHUCVU { get; set; }
    }
}
