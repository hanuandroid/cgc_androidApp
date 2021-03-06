package com.rolvatech.cgc.adapters;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rolvatech.cgc.R;
import com.rolvatech.cgc.dataobjects.StaffDTO;
import com.rolvatech.cgc.dataobjects.UserDTO;
import com.rolvatech.cgc.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class StaffListAdapter extends RecyclerView.Adapter<StaffListAdapter.ViewHolder> {

    List<UserDTO> staffDTOArrayList = new ArrayList<>();

    public StaffListAdapter(List<UserDTO> staffDTOArrayList) {
        this.staffDTOArrayList = staffDTOArrayList;
    }

    @NonNull
    @Override
    public StaffListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.staff_list, parent, false);
        return new ViewHolder(listItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StaffListAdapter.ViewHolder holder, int position) {
        UserDTO staffDTO = staffDTOArrayList.get(position);
//        if (staffDTO.getProfileImage() != null && !staffDTO.getProfileImage().equals(""))
//            holder.imageView.setImageBitmap(FileUtils.StringToBitMap(staffDTO.getProfileImage()));
        holder.staffName.setText(staffDTO.getFirstName() + " " + staffDTO.getLastName());
        holder.textView.setText("Children Count:"+staffDTO.getAssignedChildCount());
    }

    @Override
    public int getItemCount() {
        return staffDTOArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView, staffName;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.child_image);
            staffName = view.findViewById(R.id.staff_name);
            textView = view.findViewById(R.id.assigned_count);
        }
    }
}
