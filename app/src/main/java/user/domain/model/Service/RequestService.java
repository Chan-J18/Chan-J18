package user.domain.model.Service;

import android.content.Context;
import android.database.Cursor;

import com.example.servicesystem.infrastructure.Dao.Dao;

import java.util.ArrayList;
import java.util.List;

import request.domain.entity.request;
import request.infrastructure.Dao.DaoRequest;

public class RequestService {
    private Dao dao;
    private DaoRequest daoRequest;

    public  RequestService(Context context)
    {
        dao = new Dao(context);
        daoRequest = new DaoRequest(context);
    }

    public List<request> getAll()
    {
        List<request> list = new ArrayList<>();
        Cursor cursor = daoRequest.getAllReq();
        if (cursor.getCount()!=0)
        {
            while (cursor.moveToNext())
            {
                String rid = cursor.getString(0);
                String rname = cursor.getString(1);
                String rstate = cursor.getString(2);
                String rintroduce =cursor.getString(3);
                String rcontent =cursor.getString(4);
                String rtype = cursor.getString(5);
                request r = new request();
                r.setRid(rid);
                r.setRname(rname);
                r.setRcontent(rcontent);
                r.setRstate(rstate);
                r.setRintroduce(rintroduce);
                r.setRtype(rtype);
                list.add(r);
            }
        }
        cursor.close();
        return list;
    }

    public List<request> get(String id)
    {
        List<String> rids = dao.getRid(id);
        List<request> list = new ArrayList<>();
        for(int i=0;i<rids.size();i++)
        {
            Cursor cursor = daoRequest.getRequests(rids.get(i));
            if(cursor.getCount()!=0)
            {
                while (cursor.moveToNext())
                {
                    String rid = cursor.getString(0);
                    String rname = cursor.getString(1);
                    String rstate = cursor.getString(2);
                    String rintroduce =cursor.getString(3);
                    String rcontent =cursor.getString(4);
                    request r = new request();
                    r.setRid(rid);
                    r.setRname(rname);
                    r.setRcontent(rcontent);
                    r.setRstate(rstate);
                    r.setRintroduce(rintroduce);
                    list.add(r);
                }
            }
            cursor.close();
        }
        return list;
    }
}
