package rw.ac.rca.webapp.dao.impl;

import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public class MarkDAOImpl extends  DAO implements MarkDAO {


    private  static  MarkDAOImpl instance;

    public static  MarkDAOImpl getInstance() {
        if(instance == null) {
            return  new MarkDAOImpl();
        }else {
            return  instance;
        }
    }
    @Override
    public Mark saveMark(Mark mark) {
        return null;
    }

    @Override
    public Mark updateMark(Mark mark) {
        return null;
    }

    @Override
    public Mark saveOrUpdateMark(Mark mark) {
        return null;
    }

    @Override
    public boolean deleteMark(Mark mark) {
        return false;
    }

    @Override
    public Mark getMarkById(int courseId) {
        return null;
    }

    @Override
    public List<Mark> getAllMarks() {
        return null;
    }
}
