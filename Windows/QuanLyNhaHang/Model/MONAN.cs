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
    
    public partial class MONAN
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public MONAN()
        {
            this.GOIMONs = new HashSet<GOIMON>();
            this.TRANGTHAIs = new HashSet<TRANGTHAI>();
        }
    
        public int MaMon { get; set; }
        public int MaLoaiMon { get; set; }
        public string TenMon { get; set; }
        public decimal DonGia { get; set; }
        public string HinhAnh { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<GOIMON> GOIMONs { get; set; }
        public virtual LOAIMON LOAIMON { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<TRANGTHAI> TRANGTHAIs { get; set; }
    }
}
