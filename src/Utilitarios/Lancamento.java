
package Utilitarios;

public class Lancamento {
    //private int id;
    private String descricao;
    private String md_pagamento;
    private String dt_vencimento;
    private String mes;
    private String obs;
    private double valor;
    private int status;
  // private int acesso;
    

    
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public String getMd_pagamento() {
        return md_pagamento;
    }

   
    public void setMd_pagamento(String md_pagamento) {
        this.md_pagamento = md_pagamento;
    }

    
    public String getDt_vencimento() {
        return dt_vencimento;
    }

    
    public void setDt_vencimento(String dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

   
    public String getMes() {
        return mes;
    }

   
    public void setMes(String mes) {
        this.mes = mes;
    }

    
    public String getObs() {
        return obs;
    }

    
    public void setObs(String obs) {
        this.obs = obs;
    }

   
    public double getValor() {
        return valor;
    }

    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*public int getAcesso() {
        return acesso;
    }
    
    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }*/


}
