package uniquindio.edu.co;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class Aplicacion {
    public static void main(String[] args) {
        Empresa emp = new Empresa("Modastyle", 10, "Calle 14");
        int opcion;
        do{
            String entradaMenu = JOptionPane.showInputDialog(null,"Menu modastyle\n" +
                    "Sucursales y catalogo\n" +
                    "1. Registrar sucursal\n" +
                    "2. Registrar prenda en catalogo\n" +
                    "3. Registrar existencia en sucursal\n" +
                    "4. Mostrar disponibles por sucursal\n" +
                    "5. Mostrar agotados\n" +
                    "Menu registro de personas\n" +
                    "6. Registrar cliente\n" +
                    "7. Registrar vendedor\n" +
                    "8. Mostrar clientes / vendedores\n" +
                    "Menu de ventas\n" +
                    "9. Realizar venta (flujo completo)\n" +
                    "10. Mostrar ventas de un vendedor\n" +
                    "11. Mostrar compras de un cliente\n" +
                    "12. Ingresos por sucursal\n" +
                    "13. Prenda mas vendida\n" +
                    "14. Calcular precio final / total de venta\n" +
                    "0. Salir");
            if (entradaMenu == null) {
                JOptionPane.showMessageDialog(null, "Saliendo, gracias por usar.");
                break;
            }
            try {
                opcion = Integer.parseInt(entradaMenu);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                opcion = -1;
            }
            switch (opcion){
                case 0:
                    //Cerrando programa
                    JOptionPane.showMessageDialog(null, "Saliendo, gracias por usar.");
                    break;
                case 1:
                    //Registrar sucursal
                    String nombreSuc =  JOptionPane.showInputDialog("Nombre: ");
                    String codigoSuc = JOptionPane.showInputDialog("Codigo: ");
                    String direccionSuc = JOptionPane.showInputDialog("Direccion: ");
                    String ciudadSuc = JOptionPane.showInputDialog("Ciudad: ");
                    Sucursal suc = new Sucursal(nombreSuc,codigoSuc,direccionSuc,ciudadSuc);
                    if(emp.registrarSucursal(suc)){
                        JOptionPane.showMessageDialog(null, "Sucursal registrada correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null,"La sucursal no se pudo registrar.");
                    }
                    break;
                case 2:
                    //Registrar prenda en catalogo
                    String nombrePrenda = JOptionPane.showInputDialog("Nombre de prenda:");
                    String codigoPrenda = JOptionPane.showInputDialog("Codigo de la prenda:");
                    String marcaPrenda =  JOptionPane.showInputDialog("Marca de la prenda:");
                    //Introducir precio unitario
                    double precioUni;
                    while(true){
                        try {
                            precioUni = Double.parseDouble(JOptionPane.showInputDialog("Precio de la prenda:"));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Precio invalido, intentelo de nuevo.");
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "Precio invalido, intentelo de nuevo.");
                        }
                    }
                    //Introducir categoria
                    String categoriaPrenda = "";
                    CategoriaPrenda categoria = null;
                    while(true){
                        categoriaPrenda = JOptionPane.showInputDialog("Categoria de la prenda:\n- Camiseta\n- Pantalon\n- Vestido\n- Chaqueta\n- Calzado\n");
                        if(categoriaPrenda==null){
                            JOptionPane.showMessageDialog(null, "Categoria invalida.");
                            break;
                        }
                        try {
                            categoria = CategoriaPrenda.valueOf(categoriaPrenda.trim().toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, "Categoria invalida.");
                        }
                    }
                    Prenda prenda = new Prenda(nombrePrenda,codigoPrenda,marcaPrenda,precioUni,categoria);
                    if(emp.registrarPrenda(prenda)){
                        JOptionPane.showMessageDialog(null, "Prenda registrada correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null,"La prenda no se pudo registrar.");
                    }
                    break;
                case 3:
                    //Registrar existencia en sucursal
                    String textoSuc3 = "Sucursales:\n";
                    for(Sucursal s:emp.getListaSucursales()){
                        textoSuc3 += "- " + s + "\n";
                    }
                    String codigoSucursal = JOptionPane.showInputDialog(textoSuc3 + "Ingrese el codigo de la sucursal: ");
                    Sucursal sucBuscada = null;
                    for(Sucursal s:emp.getListaSucursales()){
                        if(s.getCodigo().equals(codigoSucursal)){
                            sucBuscada = s;
                        }
                    }
                    if(sucBuscada == null){
                        JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
                        break;
                    }
                    String textoPre3 = "Prendas:\n";
                    for(Prenda p:emp.getListaPrendas()){
                        textoPre3 += "- " + p + "\n";
                    }
                    String codigoPrenda1 = JOptionPane.showInputDialog(textoPre3 + "Ingrese el codigo de la prenda: ");
                    Prenda prendaBuscada = null;
                    for(Prenda p:emp.getListaPrendas()){
                        if(p.getCodigo().equals(codigoPrenda1)){
                            prendaBuscada = p;
                        }
                    }
                    if(prendaBuscada == null){
                        JOptionPane.showMessageDialog(null, "Prenda no encontrada.");
                        break;
                    }
                    String tallaPrenda = JOptionPane.showInputDialog("Ingrese la talla:\nRopa: XS, S, M, L, XL\nCalzado: 35-44");
                    String colorPrenda = JOptionPane.showInputDialog("Ingrese el color:");
                    int cantidadPrenda;
                    while(true){
                        try {
                            cantidadPrenda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida, intentelo de nuevo.");
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida, intentelo de nuevo.");
                        }
                    }
                    RegistroInventario reg = new RegistroInventario(tallaPrenda, colorPrenda, cantidadPrenda, prendaBuscada, sucBuscada);
                    if(emp.registrarExistencia(reg)){
                        JOptionPane.showMessageDialog(null, "Existencia registrada correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo registrar, revisa duplicado o talla invalida.");
                    }
                    break;
                case 4:
                    //Mostrar disponibles por sucursal
                    String textoSuc4 = "Sucursales:\n";
                    for(Sucursal s:emp.getListaSucursales()){
                        textoSuc4 += "- " + s + "\n";
                    }
                    String codigoSuc4 = JOptionPane.showInputDialog(textoSuc4 + "Codigo de la sucursal:");
                    List<RegistroInventario> disponibles = emp.consultarDisponibles(codigoSuc4);
                    if(disponibles.size() == 0){
                        JOptionPane.showMessageDialog(null, "No hay prendas disponibles en esa sucursal.");
                    }else{
                        String texto = "Disponibles en " + codigoSuc4 + ":\n";
                        for(RegistroInventario r:disponibles){
                            texto += "- " + r + "\n";
                        }
                        JOptionPane.showMessageDialog(null, texto);
                    }
                    break;
                case 5:
                    //Mostrar agotados
                    List<RegistroInventario> agotados = emp.consultarAgotados();
                    if(agotados.size() == 0){
                        JOptionPane.showMessageDialog(null, "No hay prendas agotadas.");
                    }else{
                        String textoAgo = "Agotados:\n";
                        for(RegistroInventario r:agotados){
                            textoAgo += "- " + r + " suc " + r.getSucursal().getCodigo() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, textoAgo);
                    }
                    break;
                case 6:
                    //Registrar cliente
                    String nombreCli = JOptionPane.showInputDialog("Nombre del cliente:");
                    String docCli = JOptionPane.showInputDialog("Documento del cliente:");
                    String correoCli = JOptionPane.showInputDialog("Correo del cliente:");
                    String telCli = JOptionPane.showInputDialog("Telefono del cliente:");
                    String codAfil = JOptionPane.showInputDialog("Codigo de afiliacion:");
                    //Registrar categoria
                    String catAfil = "";
                    CategoriaAfiliacion categoriaAfil = null;
                    while(true){
                        catAfil = JOptionPane.showInputDialog("Categoria:\n- Bronce\n- Plata\n- Oro");
                        if(catAfil == null){
                            break;
                        }
                        try {
                            categoriaAfil = CategoriaAfiliacion.valueOf(catAfil.trim().toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, "Categoria invalida.");
                        }
                    }
                    if(categoriaAfil == null){
                        JOptionPane.showMessageDialog(null, "Registro cancelado.");
                        break;
                    }
                    Cliente cli = new Cliente(nombreCli, docCli, correoCli, telCli, codAfil, categoriaAfil);
                    if(emp.registrarCliente(cli)){
                        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null, "El cliente no se pudo registrar, documento duplicado.");
                    }
                    break;

                case 7:
                    //Registrar vendedor
                    String nombreVen = JOptionPane.showInputDialog("Nombre del vendedor:");
                    String docVen = JOptionPane.showInputDialog("Documento del vendedor:");
                    String correoVen = JOptionPane.showInputDialog("Correo del vendedor:");
                    String telVen = JOptionPane.showInputDialog("Telefono del vendedor:");
                    String codEmp = JOptionPane.showInputDialog("Codigo de empleado:");
                    double salarioVen;
                    while(true){
                        try {
                            salarioVen = Double.parseDouble(JOptionPane.showInputDialog("Salario basico:"));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Salario invalido, intentelo de nuevo.");
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "Salario invalido, intentelo de nuevo.");
                        }
                    }
                    String textoSucVen = "Sucursales:\n";
                    for(Sucursal s:emp.getListaSucursales()){
                        textoSucVen += "- " + s + "\n";
                    }
                    String codigoSucVen = JOptionPane.showInputDialog(textoSucVen + "Codigo de la sucursal del vendedor:");
                    Sucursal sucVen = null;
                    for(Sucursal s:emp.getListaSucursales()){
                        if(s.getCodigo().equals(codigoSucVen)){
                            sucVen = s;
                        }
                    }
                    if(sucVen == null){
                        JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
                        break;
                    }
                    Vendedor ven = new Vendedor(nombreVen, docVen, correoVen, telVen, codEmp, LocalDate.now(), salarioVen, sucVen);
                    if(emp.registrarVendedor(ven)){
                        JOptionPane.showMessageDialog(null, "Vendedor registrado correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(null, "El vendedor no se pudo registrar, documento duplicado.");
                    }
                    break;

                case 8:
                    //Mostrar clientes / vendedores
                    String textoCli = "Clientes:\n";
                    for(Cliente c:emp.getListaClientes()){
                        textoCli += "- " + c + "\n";
                    }
                    String textoVen = "Vendedores:\n";
                    for(Vendedor v:emp.getListaVendedores()){
                        textoVen += "- " + v + "\n";
                    }
                    JOptionPane.showMessageDialog(null, textoCli + "\n" + textoVen);
                    break;
                case 9:

                case 10:
                    //Ventas de un vendedor
                    String textoVen10b = "Vendedores:\n";
                    for(Vendedor v:emp.getListaVendedores()){
                        textoVen10b += "- " + v + "\n";
                    }
                    String docVen10 = JOptionPane.showInputDialog(textoVen10b + "Documento del vendedor:");
                    String textoVen10 = "Ventas:\n";
                    for(Venta v:emp.ventasPorVendedor(docVen10)){
                        textoVen10 += "- " + v + "\n";
                    }
                    JOptionPane.showMessageDialog(null, textoVen10);
                    break;
                case 11:
                    //Compras de un cliente
                    String textoCli11b = "Clientes:\n";
                    for(Cliente c:emp.getListaClientes()){
                        textoCli11b += "- " + c + "\n";
                    }
                    String docCli11 = JOptionPane.showInputDialog(textoCli11b + "Documento del cliente:");
                    String textoCli11 = "Compras:\n";
                    for(Venta v:emp.comprasPorCliente(docCli11)){
                        textoCli11 += "- " + v + "\n";
                    }
                    JOptionPane.showMessageDialog(null, textoCli11);
                    break;
                case 12:

                case 13:

                case 14:
                    //Calcular precio final
                    String textoPre14 = "Prendas:\n";
                    for(Prenda p:emp.getListaPrendas()){
                        textoPre14 += "- " + p + "\n";
                    }
                    String codigoPrenda14 = JOptionPane.showInputDialog(textoPre14 + "Codigo de la prenda:");
                    Prenda p14 = null;
                    for(Prenda p:emp.getListaPrendas()){
                        if(p.getCodigo().equals(codigoPrenda14)){
                            p14 = p;
                        }
                    }
                    String textoCli14 = "Clientes:\n";
                    for(Cliente c:emp.getListaClientes()){
                        textoCli14 += "- " + c + "\n";
                    }
                    String docCli14 = JOptionPane.showInputDialog(textoCli14 + "Documento del cliente:");
                    Cliente c14 = null;
                    for(Cliente c:emp.getListaClientes()){
                        if(c.getDocumento().equals(docCli14)){
                            c14 = c;
                        }
                    }
                    if(p14 == null || c14 == null){
                        JOptionPane.showMessageDialog(null, "Prenda o cliente no encontrado.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Precio con recargo $" + p14.calcularPrecioConRecargo() + "\nPrecio final $" + emp.calcularPrecioFinal(p14, c14));
                    break;
                default:
                    break;
            }
        }while(opcion!=0);
    }
}
