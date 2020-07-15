package com.example.quanlynhahang.ui.tools;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import com.example.quanlynhahang.R;
import com.example.quanlynhahang.ui.home.CustomListAdapter;
import com.example.quanlynhahang.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private ArrayList<String> dsmagoimon = new ArrayList<String>();
    private ArrayList<String> dstenmon = new ArrayList<String>();
    private ArrayList<String> dsdongia = new ArrayList<String>();
    private ArrayList<String> dsthanhtien = new ArrayList<String>();
    private ArrayList<String> dshinhanh = new ArrayList<String>();
    private ArrayList<String> dssoluong = new ArrayList<String>();
    private ArrayList<String> dssoluong1 = new ArrayList<String>();
    private ArrayList<String> dstongsl = new ArrayList<String>();
    private ArrayList<String> dsmamon = new ArrayList<String>();
    private ArrayList<String> dstrangthai1 = new ArrayList<String>();
    private ThucDon thucDon;
    private List<ThucDon> list1 = new ArrayList<ThucDon>();
    private String[] HinhAnh = null;
    private String MaBan;
    private ListView lv;
    private TextView textView;
    private int TongTien;
    private Bundle bundle;
    private TextView textView1;
    private DanhSachThucDon danhSachThucDon = new DanhSachThucDon();
    private CustomListAdapter2 customListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        textView1 = root.findViewById(R.id.txtdanhsachthucdon);
        textView = root.findViewById(R.id.text_tools);
        lv = root.findViewById(R.id.list_item1);
        bundle = getArguments();

        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                LoadThucDon();
            }
        });
        return root;
    }

    private static String TienTe(String Tien) {
        DecimalFormat format = new DecimalFormat("###,###,##0");
        return format.format(Double.parseDouble(Tien));
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.danhsachthucdon, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int i = info.position;
        AdapterView.AdapterContextMenuInfo info1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.add: {
                final Bundle bundle1 = getArguments();
                if (bundle1 != null) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    LayoutInflater layoutInflater = getActivity().getLayoutInflater();
                    View view = layoutInflater.inflate(R.layout.themmon, null);

                    final TextInputEditText editText = view.findViewById(R.id.soluong);
                    builder.setView(view)
                            .setTitle("Thay đổi")
                            .setPositiveButton("Thay đổi", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String MaGoiMon = dsmagoimon.get(i);
                                    String SoLuong1 = dssoluong.get(i);
                                    String MaMon = dsmamon.get(i);
                                    String MaBan = bundle1.get("MaBan").toString();
                                    String SoLuong = editText.getText().toString();
                                    int s3 = Integer.parseInt(SoLuong1);
                                    if (editText.getText().toString().length()>0)
                                    {
                                        int s2 = Integer.parseInt(SoLuong);
                                        if (MaBan != null) {
                                            if (MaGoiMon != null) {
                                                if (s2 < s3) {
                                                    dstongsl = danhSachThucDon.KiemTraTT(MaBan, MaMon, "Chưa làm");
                                                    String a = dstongsl.get(0);
                                                    if (a != null) {
                                                        int s1 = Integer.parseInt(dstongsl.get(0));
                                                        int s4 = s3 - s2;
                                                        if (s4 <= s1) {
                                                            dstrangthai1 = danhSachThucDon.getDstrangthai1(MaBan, MaMon, "Chưa làm");
                                                            if (dstrangthai1.size() > 0) {
                                                                int s5 = s3 - s2;
                                                                for (int i = 0; i < dstrangthai1.size(); i++) {
                                                                    try {
                                                                        dssoluong1 = danhSachThucDon.KiemTraSL(MaBan, MaMon, "Chưa làm");
                                                                        int s6 = Integer.parseInt(dssoluong1.get(0));
                                                                        if (s6 <= s5) {
                                                                            danhSachThucDon.DeleteTrangThai(MaMon, MaBan, "Chưa làm");
                                                                            danhSachThucDon.UpdateThucDon(MaGoiMon, SoLuong);
                                                                            danhSachThucDon.DeleteGoiMon(MaGoiMon);
                                                                            dssoluong1.clear();
                                                                        } else {
                                                                            danhSachThucDon.UpdateTrangThai(MaMon, s5, MaBan, "Chưa làm");
                                                                            danhSachThucDon.UpdateThucDon(MaGoiMon, SoLuong);
                                                                            danhSachThucDon.DeleteGoiMon(MaGoiMon);
                                                                            dssoluong1.clear();
                                                                        }
                                                                        s5 -= s6;
                                                                    } catch (Exception ex) {

                                                                    }
                                                                }
                                                                list1.clear();
                                                                LoadThucDon();
                                                                Toast.makeText(getActivity(), "Bạn đã cập nhật số lượng món thành công!", Toast.LENGTH_LONG).show();
                                                            } else {
                                                                Toast.makeText(getActivity(), "Món ăn đã làm xong!", Toast.LENGTH_LONG).show();
                                                            }
                                                        } else {
                                                            Toast.makeText(getActivity(), "Vui lòng giảm lại số lượng món cần thay đổi!", Toast.LENGTH_LONG).show();
                                                        }
                                                    } else {
                                                        Toast.makeText(getActivity(), "Món ăn đã làm xong!", Toast.LENGTH_LONG).show();
                                                        dstongsl.clear();
                                                    }
                                                } else {
                                                    Toast.makeText(getActivity(), "Vui lòng giảm lại số lượng món cần thay đổi!", Toast.LENGTH_LONG).show();
                                                }
                                            } else {
                                                Toast.makeText(getActivity(), "Vui lòng chọn món trước khi cập nhật!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                        else
                                        {

                                        }
                                    }
                                    else
                                    {
                                        Toast.makeText(getActivity(),"Vui lòng nhập số lượng!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .setNegativeButton("Quay lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
            break;
            case R.id.exit:

                break;
        }
        return super.onContextItemSelected(item);
    }

    private void LoadThucDon() {
        if (bundle != null) {
            MaBan = bundle.get("MaBan").toString();
            dsmamon = danhSachThucDon.getMaMon(MaBan);
            dstenmon = danhSachThucDon.getTenMon(MaBan);
            dsdongia = danhSachThucDon.getDonGia(MaBan);
            dshinhanh = danhSachThucDon.getHinhAnh(MaBan);
            dsmagoimon = danhSachThucDon.getMaGoiMon(MaBan);
            dssoluong = danhSachThucDon.getSoLuong(MaBan);
            dsthanhtien = danhSachThucDon.getThanhTien(MaBan);
            textView1.setVisibility(View.VISIBLE);
            lv.setVisibility(View.VISIBLE);
            if (dsmagoimon.size() > 0) {
                TongTien = 0;
                for (int i = 0; i < dsmagoimon.size(); i++) {
                    TongTien += Integer.valueOf(dsthanhtien.get(i));
                    HinhAnh = dshinhanh.get(i).toString().split("\\.jpg");
                    thucDon = new ThucDon(dstenmon.get(i), HinhAnh[0], TienTe(dsdongia.get(i)) + " VNĐ", dssoluong.get(i), TienTe(dsthanhtien.get(i)) + " VNĐ", dsmagoimon.get(i), dsmamon.get(i));
                    list1.add(thucDon);
                }
                customListAdapter = new CustomListAdapter2(getActivity(), list1);
                lv.setAdapter(customListAdapter);
                if (dsmagoimon.get(0)==null)
                {
                    textView.setText("");
                }
                else
                {
                    textView.setText("Tổng tiền là: " + TienTe(String.valueOf(TongTien)) + " VNĐ");
                }
                registerForContextMenu(lv);

            } else {
                textView1.setVisibility(View.INVISIBLE);
                lv.setVisibility(View.INVISIBLE);
            }
        } else {
            textView1.setVisibility(View.INVISIBLE);
            lv.setVisibility(View.INVISIBLE);
        }
    }
}