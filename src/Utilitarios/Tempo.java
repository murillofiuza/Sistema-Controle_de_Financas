
package Utilitarios;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Tempo {
 private String mes;
    private String mes2;
    private String dia;
    private String ano;
    private String dia_semana;
    private String hora;
    private String data;
    private String dataNota;
    
    private SimpleDateFormat horaFormatada= new SimpleDateFormat("HH:mm:ss");
    
public void le_hora(){
    java.util.Date horaAtual=new java.util.Date();
        setHora(getHoraFormatada().format(horaAtual));
}

public void le_data2()
{
java.util.Date data=new java.util.Date();
//mes=""+data.getMonth();
        setDia(""+data.getDate());
        setAno(""+(1900+data.getYear()));
//dia_semana=""+data.getDay();

switch(data.getDay()){
    case 0:setDia_semana("Domingo");break;
    case 1:setDia_semana("Segunda");break;
    case 2:setDia_semana("Terça");break;
    case 3:setDia_semana("Quarta");break;
    case 4:setDia_semana("Quinta");break;
    case 5:setDia_semana("Sexta");break;
    case 6:setDia_semana("Sabado");break;
}

switch(data.getMonth()){
    case 0:setMes2("Janeiro");break;
    case 1:setMes2("Fevereiro");break;
    case 2:setMes2("Março");break;
    case 3:setMes2("Abril");break;
    case 4:setMes2("Maio");break;
    case 5:setMes2("Junho");break;
    case 6:setMes2("Julho");break;
    case 7:setMes2("Agosto");break;
    case 8:setMes2("Setembro");break;
    case 9:setMes2("Outubro");break;
    case 10:setMes2("Novembro");break;
    case 11:setMes2("Dezembro");break;
}
}
public void le_data()
{
java.util.Date data=new java.util.Date();
//mes=""+data.getMonth();
        setDia(""+data.getDate());
        setAno(""+(1900+data.getYear()));
//dia_semana=""+data.getDay();

switch(data.getDay()){
    case 0:setDia_semana("Domingo");break;
    case 1:setDia_semana("Segunda");break;
    case 2:setDia_semana("Terça");break;
    case 3:setDia_semana("Quarta");break;
    case 4:setDia_semana("Quinta");break;
    case 5:setDia_semana("Sexta");break;
    case 6:setDia_semana("Sabado");break;
}

switch(data.getMonth()){
    case 0:setMes("01");break;
    case 1:setMes("02");break;
    case 2:setMes("03");break;
    case 3:setMes("04");break;
    case 4:setMes("05");break;
    case 5:setMes("06");break;
    case 6:setMes("07");break;
    case 7:setMes("08");break;
    case 8:setMes("09");break;
    case 9:setMes("10");break;
    case 10:setMes("11");break;
    case 11:setMes("12");break;
   }
}

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
   
    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataNota() {
        return dataNota;
    }

    public void setDataNota(String dataNota) {
        this.dataNota = dataNota;
    }

    public SimpleDateFormat getHoraFormatada() {
        return horaFormatada;
    }

    public void setHoraFormatada(SimpleDateFormat horaFormatada) {
        this.horaFormatada = horaFormatada;
    }

}
