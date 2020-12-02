package fr.utbm.lo54.service;

import fr.utbm.lo54.beans.Location;
import fr.utbm.lo54.repository.LocationDAO;

import java.util.List;

public class LocationService {
    public List<Location> listCities(){
        LocationDAO ldao = new LocationDAO();
        return ldao.listCity();
    }
}
