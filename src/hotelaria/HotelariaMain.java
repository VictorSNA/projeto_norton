/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

/**
 *
 * @author Thiago
 */
public class HotelariaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Atendente a1;
        Atendente a2;
        a1 = new Atendente("John", "John Doe", "johndoe@gmail.com", "123");
        a2 = new Atendente("John", "John Doe", "johndoe@gmail.com", "123");
        
        Cliente cl1;
        cl1 = new Cliente("Jobson Marciano","Rua Big Street Family","0000-1111",
                         "Vergueiro","São Paulo", "São Paulo", "12/09/2022", "000000000");
        
        ConsumoCliente h1;
        h1 = new ConsumoCliente("Café da manhã", 200.98, "12/05/2030");
        
        Conta co1;
        co1 = new Conta(2000, 200.98, 20);
        
        Deposito d1;
        d1 = new Deposito("3001", "12/05/2030", 410.00);
        
        Relatorio r1;
        r1 = new Relatorio("12/05/2030");
        
        Quarto q1;
        q1 = new Quarto(1, "Básico", "1 pessoa", false);
        
        Reserva re1;
        re1 = new Reserva(q1, cl1, "12-05-2030", "12-05-2030", 410, true );
    }
    
}
