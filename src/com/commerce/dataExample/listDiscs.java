package com.commerce.dataExample;

import com.commerce.model.Disc;
import com.commerce.service.DiscService;

public class listDiscs {
    public static void cargarDiscosPrueba(DiscService serv){
        

        serv.nuevoDisc(new Disc("The soundhouse tapes", "/uploads/img/front.jpg", "/uploads/img/back.jpg", "/uploads/img/disc.jpg", "Emi", "Iron Maiden", "10/11/1979", "Primer single", 23050.00, 5, "Heavy Metal"));
        serv.nuevoDisc(new Disc("Runnig Free", "/uploads/img/front.jpg", "/uploads/img/back.jpg", "/uploads/img/disc.jpg", "Emi", "Iron Maiden", "08/02/1980", "Segundo single", 21700.00, 5, "Heavy Metal"));
        serv.nuevoDisc(new Disc("Sanctuary", "/uploads/img/front.jpg", "/uploads/img/back.jpg", "/uploads/img/disc.jpg", "Emi", "Iron Maiden", "23/05/1980", "Tercer single", 18300.50, 1, "Heavy Metal"));
        serv.nuevoDisc(new Disc("Women in Uniform", "/uploads/img/front.jpg", "/uploads/img/back.jpg", "/uploads/img/disc.jpg", "Emi", "Iron Maiden", "17/10/1980", "Cuarto single", 28500.00, 4, "Heavy Metal"));
        serv.nuevoDisc(new Disc("Twillight Zone", "/uploads/img/front.jpg", "/uploads/img/back.jpg", "/uploads/img/disc.jpg", "Emi", "Iron Maiden", "02/03/1981", "Quinto single", 13350.00, 7, "Heavy Metal"));
    }
}
