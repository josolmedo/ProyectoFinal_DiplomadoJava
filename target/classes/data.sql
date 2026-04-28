-- ============================================================
-- 1) ROLES
-- ============================================================
INSERT INTO Roles (id, nombre) VALUES
                                   (1, 'Administrador'),
                                   (2, 'Profesor'),
                                   (3, 'Alumno'),
                                   (4, 'Padre de familia');


-- ============================================================
-- 2) USUARIOS (Admins, Profesores, Papás, Alumnos)
-- ============================================================
INSERT INTO Usuarios (nombre, apellido, email, password, id_rol) VALUES
-- Admins (1)
('Admin','General','admin@escuela.mx','hash_admin',1),

-- Profesores (25)
('María','Hernández','maria.hernandez@escuela.mx','hash123',2),
('José','Ramírez','jose.ramirez@escuela.mx','hash123',2),
('Ana','Santos','ana.santos@escuela.mx','hash123',2),
('Luis','Pérez','luis.perez@escuela.mx','hash123',2),
('Carolina','Mendoza','carolina.mendoza@escuela.mx','hash123',2),
('Jorge','Flores','jorge.flores@escuela.mx','hash123',2),
('Beatriz','Martínez','beatriz.martinez@escuela.mx','hash123',2),
('Hugo','Castillo','hugo.castillo@escuela.mx','hash123',2),
('Claudia','Ríos','claudia.rios@escuela.mx','hash123',2),
('Rafael','Cortés','rafael.cortes@escuela.mx','hash123',2),
('Diana','Vargas','diana.vargas@escuela.mx','hash123',2),
('Pablo','Luna','pablo.luna@escuela.mx','hash123',2),
('Laura','Gómez','laura.gomez@escuela.mx','hash123',2),
('Daniel','Ortega','daniel.ortega@escuela.mx','hash123',2),
('Sofía','Salazar','sofia.salazar@escuela.mx','hash123',2),
('Miguel','Silva','miguel.silva@escuela.mx','hash123',2),
('Carmen','Rojas','carmen.rojas@escuela.mx','hash123',2),
('Ricardo','Navarro','ricardo.navarro@escuela.mx','hash123',2),
('Patricia','Miranda','patricia.miranda@escuela.mx','hash123',2),
('Iván','Serrano','ivan.serrano@escuela.mx','hash123',2),
('Gabriela','Delgado','gabriela.delgado@escuela.mx','hash123',2),
('Felipe','Aguilar','felipe.aguilar@escuela.mx','hash123',2),
('Monserrat','Ibarra','monserrat.ibarra@escuela.mx','hash123',2),
('Ernesto','Valdés','ernesto.valdes@escuela.mx','hash123',2),
('Adriana','Cuéllar','adriana.cuellar@escuela.mx','hash123',2),

-- Padres (150)
('Juan','Lozano','juan.lozano@correo.com','hash_padre',4),
('María','Suárez','maria.suarez@correo.com','hash_padre',4),
('Javier','Campos','javier.campos@correo.com','hash_padre',4),
('Lucía','Beltrán','lucia.beltran@correo.com','hash_padre',4),
('Roberto','Camacho','roberto.camacho@correo.com','hash_padre',4),
('Elena','Pineda','elena.pineda@correo.com','hash_padre',4),
('Fernando','Acosta','fernando.acosta@correo.com','hash_padre',4),
('Rosa','Esquivel','rosa.esquivel@correo.com','hash_padre',4),
('Gerardo','Valle','gerardo.valle@correo.com','hash_padre',4),
('Leticia','Covarrubias','leticia.covarrubias@correo.com','hash_padre',4),
('Manuel','Soria','manuel.soria@correo.com','hash_padre',4),
('Patricia','Benítez','patricia.benitez@correo.com','hash_padre',4),
('Armando','Blanco','armando.blanco@correo.com','hash_padre',4),
('Marta','Venegas','marta.venegas@correo.com','hash_padre',4),
('Oscar','Zavala','oscar.zavala@correo.com','hash_padre',4),
('Rebeca','Quintero','rebeca.quintero@correo.com','hash_padre',4),
('Diego','Mejía','diego.mejia@correo.com','hash_padre',4),
('Susana','Villaseñor','susana.villasenor@correo.com','hash_padre',4),
('Alberto','Quiroz','alberto.quiroz@correo.com','hash_padre',4),
('Paula','Chávez','paula.chavez@correo.com','hash_padre',4),
('Víctor','Corona','victor.corona@correo.com','hash_padre',4),
('Sandra','Trejo','sandra.trejo@correo.com','hash_padre',4),
('Eduardo','Arriaga','eduardo.arriaga@correo.com','hash_padre',4),
('Norma','Vite','norma.vite@correo.com','hash_padre',4),
('Tomás','Gudiño','tomas.gudino@correo.com','hash_padre',4),
('Clara','Altamirano','clara.altamirano@correo.com','hash_padre',4),
('Guillermo','Tovar','guillermo.tovar@correo.com','hash_padre',4),
('Irene','Prado','irene.prado@correo.com','hash_padre',4),
('Ramón','Huerta','ramon.huerta@correo.com','hash_padre',4),
('Fabiola','Borja','fabiola.borja@correo.com','hash_padre',4),
('Héctor','Salcedo','hector.salcedo@correo.com','hash_padre',4),
('Marina','Cervantes','marina.cervantes@correo.com','hash_padre',4),
('Santiago','Nava','santiago.nava@correo.com','hash_padre',4),
('Isabel','Córdova','isabel.cordova@correo.com','hash_padre',4),
('Raúl','Molina','raul.molina@correo.com','hash_padre',4),
('Nora','Palacios','nora.palacios@correo.com','hash_padre',4),
('Max','Estrada','max.estrada@correo.com','hash_padre',4),
('Lourdes','Saldívar','lourdes.saldivar@correo.com','hash_padre',4),
('Óscar','Perales','oscar.perales@correo.com','hash_padre',4),
('Bárbara','Munguía','barbara.munguia@correo.com','hash_padre',4),
('Cristóbal','Olaiz','cristobal.olaiz@correo.com','hash_padre',4),
('Rocío','Lara','rocio.lara@correo.com','hash_padre',4),
('Raquel','Salinas','raquel.salinas@correo.com','hash_padre',4),
('Martín','Vidal','martin.vidal@correo.com','hash_padre',4),
('Leticia','Paz','leticia.paz@correo.com','hash_padre',4),
('Félix','Aranda','felix.aranda@correo.com','hash_padre',4),
('Adela','Noriega','adela.noriega@correo.com','hash_padre',4),
('Joel','Mata','joel.mata@correo.com','hash_padre',4),
('Mónica','Arias','monica.arias@correo.com','hash_padre',4),
('Armida','Gallardo','armida.gallardo@correo.com','hash_padre',4),
('Humberto','Yáñez','humberto.yanez@correo.com','hash_padre',4),
('Bianca','Castaño','bianca.castano@correo.com','hash_padre',4),
('Eduardo','Paz','eduardo.paz@correo.com','hash_padre',4),
('Catalina','Miranda','catalina.miranda@correo.com','hash_padre',4),
('Octavio','Barrera','octavio.barrera@correo.com','hash_padre',4),
('Ruth','Cardenas','ruth.cardenas@correo.com','hash_padre',4),
('Saúl','Vargas','saul.vargas@correo.com','hash_padre',4),
('Grecia','Bustos','grecia.bustos@correo.com','hash_padre',4),
('Luciano','Aguado','luciano.aguado@correo.com','hash_padre',4),
('Magdalena','Ponce','magdalena.ponce@correo.com','hash_padre',4),
('Ciro','Vega','ciro.vega@correo.com','hash_padre',4),
('Viridiana','Crespo','viridiana.crespo@correo.com','hash_padre',4),
('Germán','Sánchez','german.sanchez@correo.com','hash_padre',4),
('Nadia','Pantoja','nadia.pantoja@correo.com','hash_padre',4),
('Efrén','Jáuregui','efren.jauregui@correo.com','hash_padre',4),
('Paloma','Serralde','paloma.serralde@correo.com','hash_padre',4),
('Gonzalo','Cervantes','gonzalo.cervantes@correo.com','hash_padre',4),
('Mireya','Trujillo','mireya.trujillo@correo.com','hash_padre',4),
('Héctor','Bernal','hector.bernal@correo.com','hash_padre',4),
('Yolanda','Rangel','yolanda.rangel@correo.com','hash_padre',4),
('Tania','Mendoza','tania.mendoza@correo.com','hash_padre',4),
('Aurelio','Pineda','aurelio.pineda@correo.com','hash_padre',4),
('Rogelio','Alonso','rogelio.alonso@correo.com','hash_padre',4),
('Eunice','Márquez','eunice.marquez@correo.com','hash_padre',4),
('Salvador','Del Río','salvador.delrio@correo.com','hash_padre',4),
('Beto','Haro','beto.haro@correo.com','hash_padre',4),
('Lidia','Figueroa','lidia.figueroa@correo.com','hash_padre',4),
('Aldo','Vargas','aldo.vargas@correo.com','hash_padre',4),
('Pilar','Estrada','pilar.estrada@correo.com','hash_padre',4),
('Joaquín','López','joaquin.lopez@correo.com','hash_padre',4),
('Noemí','Cisneros','noemi.cisneros@correo.com','hash_padre',4),
('Eulalia','Reza','eulalia.reza@correo.com','hash_padre',4),
('Ramona','Cárdenas','ramona.cardenas@correo.com','hash_padre',4),
('Gisela','Aguirre','gisela.aguirre@correo.com','hash_padre',4),
('César','Ferrer','cesar.ferrer@correo.com','hash_padre',4),
('Bruno','Paz','bruno.paz@correo.com','hash_padre',4),
('Nicol','Paniagua','nicol.paniagua@correo.com','hash_padre',4),
('Luz','Osorio','luz.osorio@correo.com','hash_padre',4),
('Mauro','Rico','mauro.rico@correo.com','hash_padre',4),
('Denisse','Lugo','denisse.lugo@correo.com','hash_padre',4),
('Octavia','Hidalgo','octavia.hidalgo@correo.com','hash_padre',4),
('Rubén','Tapia','ruben.tapia@correo.com','hash_padre',4),
('Greta','Santillán','greta.santillan@correo.com','hash_padre',4),
('Ariadna','Lozano','ariadna.lozano@correo.com','hash_padre',4),
('Fabricio','Cuevas','fabricio.cuevas@correo.com','hash_padre',4),
('Yahir','Villalobos','yahir.villalobos@correo.com','hash_padre',4),
('Rafael','Pineda','rafael.pineda@correo.com','hash_padre',4),
('Irma','Chávez','irma.chavez@correo.com','hash_padre',4),
('Sergio','Ledesma','sergio.ledesma@correo.com','hash_padre',4),
('Lilian','Duarte','lilian.duarte@correo.com','hash_padre',4),
('Mauro','Ferrer','mauro.ferrer@correo.com','hash_padre',4),
('Celeste','Lara','celeste.lara@correo.com','hash_padre',4),
('Arnoldo','Cepeda','arnoldo.cepeda@correo.com','hash_padre',4),
('Julieta','Monroy','julieta.monroy@correo.com','hash_padre',4),
('Rodolfo','Medina','rodolfo.medina@correo.com','hash_padre',4),
('Estela','Herrera','estela.herrera@correo.com','hash_padre',4),
('Milton','Vargas','milton.vargas@correo.com','hash_padre',4),
('Iris','Castañeda','iris.castaneda@correo.com','hash_padre',4),
('Fermin','Salvador','fermin.salvador@correo.com','hash_padre',4),
('Enrique','Lozano','enrique.lozano@correo.com','hash_padre',4),
('Gloria','Sánchez','gloria.sanchez@correo.com','hash_padre',4),
('Tobías','Gómez','tobias.gomez@correo.com','hash_padre',4),
('Mariana','Romero','mariana.romero@correo.com','hash_padre',4),
('Irving','Navarro','irving.navarro@correo.com','hash_padre',4),
('Graciela','Santos','graciela.santos@correo.com','hash_padre',4),
('Alma','Hernández','alma.hernandez@correo.com','hash_padre',4),
('Federico','Ortiz','federico.ortiz@correo.com','hash_padre',4),
('Cecilia','Rojo','cecilia.rojo@correo.com','hash_padre',4),
('Óscar','Moreno','oscar.moreno@correo.com','hash_padre',4),
('Julia','Vázquez','julia.vazquez@correo.com','hash_padre',4),
('Horacio','Belmonte','horacio.belmonte@correo.com','hash_padre',4),
('Adriana','Lara','adriana.lara@correo.com','hash_padre',4),
('Hilda','Mendoza','hilda.mendoza@correo.com','hash_padre',4),


-- Alumnos
('Aldo','Reyes','aldo.reyes@alumnos.local','hash_alumno',3),
('Marisol','Cano','marisol.cano@alumnos.local','hash_alumno',3),
('José','Olmedo','joseangelolmedoguevara@gmail.com','hash_alumno',3),
('Daniela','Ochoa','daniela.ochoa@alumnos.local','hash_alumno',3),
('Sergio','Toledo','sergio.toledo@alumnos.local','hash_alumno',3),
('Citlali','Juárez','citlali.juarez@alumnos.local','hash_alumno',3),
('Héctor','Saavedra','hector.saavedra@alumnos.local','hash_alumno',3),
('Araceli','Zamora','araceli.zamora@alumnos.local','hash_alumno',3),
('Joel','Morales','joel.morales@alumnos.local','hash_alumno',3),
('Miranda','Barrera','miranda.barrera@alumnos.local','hash_alumno',3),
('Miguel','Iñiguez','miguel.iniguez@alumnos.local','hash_alumno',3),
('Tamara','Suaste','tamara.suaste@alumnos.local','hash_alumno',3),
('Kevin','Arteaga','kevin.arteaga@alumnos.local','hash_alumno',3),
('Romina','Lugo','romina.lugo@alumnos.local','hash_alumno',3),
('Erick','Solís','erick.solis@alumnos.local','hash_alumno',3),
('Verónica','Justo','veronica.justo@alumnos.local','hash_alumno',3),
('Mauricio','Cruz','mauricio.cruz@alumnos.local','hash_alumno',3),
('Karen','Pérez','karen.perez@alumnos.local','hash_alumno',3),
('Diego','Velasco','diego.velasco@alumnos.local','hash_alumno',3),
('Jimena','Aguirre','jimena.aguirre@alumnos.local','hash_alumno',3),
('José','Ávila','jose.avila@alumnos.local','hash_alumno',3),
('Alejandra','Olivares','alejandra.olivares@alumnos.local','hash_alumno',3),
('Cristian','Lopez','cristian.lopez@alumnos.local','hash_alumno',3),
('Melissa','Nava','melissa.nava@alumnos.local','hash_alumno',3),
('Marcos','Téllez','marcos.tellez@alumnos.local','hash_alumno',3),
('Valeria','Vargas','valeria.vargas@alumnos.local','hash_alumno',3),
('Jair','Peña','jair.pena@alumnos.local','hash_alumno',3),
('Axel','Gómez','axel.gomez@alumnos.local','hash_alumno',3),
('Renata','Fierro','renata.fierro@alumnos.local','hash_alumno',3),
('Sebastián','Castañeda','sebastian.castaneda@alumnos.local','hash_alumno',3),
('Brenda','Arias','brenda.arias@alumnos.local','hash_alumno',3),
('Gustavo','Ponce','gustavo.ponce@alumnos.local','hash_alumno',3),
('Lidia','Cruz','lidia.cruz@alumnos.local','hash_alumno',3),
('Santiago','Díaz','santiago.diaz@alumnos.local','hash_alumno',3),
('Ingrid','Morán','ingrid.moran@alumnos.local','hash_alumno',3),
('Fabricio','Sosa','fabricio.sosa@alumnos.local','hash_alumno',3),
('Luna','Sánchez','luna.sanchez@alumnos.local','hash_alumno',3),
('Emanuel','Ríos','emanuel.rios@alumnos.local','hash_alumno',3),
('Natalia','Vega','natalia.vega@alumnos.local','hash_alumno',3),
('Julián','Paz','julian.paz@alumnos.local','hash_alumno',3),
('Sandra','Ortiz','sandra.ortiz@alumnos.local','hash_alumno',3),
('Óscar','Rubio','oscar.rubio@alumnos.local','hash_alumno',3),
('Elisa','González','elisa.gonzalez@alumnos.local','hash_alumno',3),
('Tobías','Mena','tobias.mena@alumnos.local','hash_alumno',3),
('Bruno','Lozano','bruno.lozano@alumnos.local','hash_alumno',3),
('Carla','Saldaña','carla.saldana@alumnos.local','hash_alumno',3),
('Raúl','Cordero','raul.cordero@alumnos.local','hash_alumno',3),
('Yolanda','Mata','yolanda.mata@alumnos.local','hash_alumno',3),
('Eduardo','Salinas','eduardo.salinas@alumnos.local','hash_alumno',3),
('Mariana','Pérez','mariana.perez@alumnos.local','hash_alumno',3),
('Fabricia','Sierra','fabricia.sierra@alumnos.local','hash_alumno',3),
('Saúl','Vega','saul.vega@alumnos.local','hash_alumno',3),
('Álvaro','Navarro','alvaro.navarro@alumnos.local','hash_alumno',3),
('Ariadna','Cruz','ariadna.cruz@alumnos.local','hash_alumno',3),
('Tomás','Hernández','tomas.hernandez@alumnos.local','hash_alumno',3),
('Ximena','Ferrer','ximena.ferrer@alumnos.local','hash_alumno',3),
('Emilio','Ruiz','emilio.ruiz@alumnos.local','hash_alumno',3),
('Noelia','Pérez','noelia.perez@alumnos.local','hash_alumno',3),
('César','Soto','cesar.soto@alumnos.local','hash_alumno',3),
('María José','Villar','mariajose.villar@alumnos.local','hash_alumno',3),
('Diego Fernando','Araujo','diego.araujo@alumnos.local','hash_alumno',3),
('Reyna','Ortiz','reyna.ortiz@alumnos.local','hash_alumno',3),
('Alan','Mendoza','alan.mendoza@alumnos.local','hash_alumno',3),
('Karla','Soria','karla.soria@alumnos.local','hash_alumno',3),
('Ivette','Gil','ivette.gil@alumnos.local','hash_alumno',3),
('Mario','Villarreal','mario.villarreal@alumnos.local','hash_alumno',3),
('Blanca','Valdez','blanca.valdez@alumnos.local','hash_alumno',3),
('Marco','Álvarez','marco.alvarez@alumnos.local','hash_alumno',3),
('Paulina','Herrera','paulina.herrera@alumnos.local','hash_alumno',3),
('René','Camacho','rene.camacho@alumnos.local','hash_alumno',3),
('Liz','Gómez','liz.gomez@alumnos.local','hash_alumno',3),
('Gina','Córdova','gina.cordova@alumnos.local','hash_alumno',3),
('Rubén','Salcedo','ruben.salcedo@alumnos.local','hash_alumno',3),
('Monica','Lomeli','monica.lomeli@alumnos.local','hash_alumno',3),
('Cecilio','Paredes','cecilio.paredes@alumnos.local','hash_alumno',3),
('Fátima','Ortega','fatima.ortega@alumnos.local','hash_alumno',3),
('Adán','Montes','adan.montes@alumnos.local','hash_alumno',3),
('Betsy','Cruz','betsy.cruz@alumnos.local','hash_alumno',3),
('Alicia','Sotelo','alicia.sotelo@alumnos.local','hash_alumno',3),
('Hugo','Alcaraz','hugo.alcaraz@alumnos.local','hash_alumno',3),
('Mia','Ramos','mia.ramos@alumnos.local','hash_alumno',3),
('Fabián','Zarate','fabian.zarate@alumnos.local','hash_alumno',3),
('Omar','Reyna','omar.reyna@alumnos.local','hash_alumno',3),
('Iván','Salmerón','ivan.salmeron@alumnos.local','hash_alumno',3),
('Milena','Cortés','milena.cortes@alumnos.local','hash_alumno',3),
('Néstor','Páez','nestor.paez@alumnos.local','hash_alumno',3),
('Yaretzi','Paz','yaretzi.paz@alumnos.local','hash_alumno',3),
('Gabino','Vega','gabino.vega@alumnos.local','hash_alumno',3),
('Magda','López','magda.lopez@alumnos.local','hash_alumno',3),
('Oscar','Pineda','oscar.pineda@alumnos.local','hash_alumno',3),
('Lina','Alvarez','lina.alvarez@alumnos.local','hash_alumno',3),
('Nadia','Serrano','nadia.serrano@alumnos.local','hash_alumno',3),
('Renzo','Meraz','renzo.meraz@alumnos.local','hash_alumno',3),
('Iker','Domínguez','iker.dominguez@alumnos.local','hash_alumno',3),
('Dulce','Mateos','dulce.mateos@alumnos.local','hash_alumno',3),
('Joel','Galván','joel.galvan@alumnos.local','hash_alumno',3),
('Bárbara','López','barbara.lopez@alumnos.local','hash_alumno',3),
('Brenda','Castro','brenda.castro@alumnos.local','hash_alumno',3),
('Ainhoa','Rojas','ainhoa.rojas@alumnos.local','hash_alumno',3),
('Iván','Cervantes','ivan.cervantes@alumnos.local','hash_alumno',3),
('Mariana','Félix','mariana.felix@alumnos.local','hash_alumno',3),
('Román','Reyes','roman.reyes@alumnos.local','hash_alumno',3),
('Rocío','Beltrán','rocio.beltran@alumnos.local','hash_alumno',3),
('Simón','Paz','simon.paz@alumnos.local','hash_alumno',3),
('Lucero','Montoya','lucero.montoya@alumnos.local','hash_alumno',3),
('Gonzalo','Tovar','gonzalo.tovar@alumnos.local','hash_alumno',3),
('Nora','Medina','nora.medina@alumnos.local','hash_alumno',3),
('Tom','Herrera','tom.herrera@alumnos.local','hash_alumno',3),
('Lourdes','Molina','lourdes.molina@alumnos.local','hash_alumno',3),
('Iván','Valle','ivan.valle@alumnos.local','hash_alumno',3),
('Gala','Montero','gala.montero@alumnos.local','hash_alumno',3),
('Greta','Zamudio','greta.zamudio@alumnos.local','hash_alumno',3),
('Xóchitl','Ramos','xochitl.ramos@alumnos.local','hash_alumno',3),
('Enzo','Cáceres','enzo.caceres@alumnos.local','hash_alumno',3),
('Nerea','López','nerea.lopez@alumnos.local','hash_alumno',3),
('Samuel','Vidal','samuel.vidal@alumnos.local','hash_alumno',3),
('Gema','Hernández','gema.hernandez@alumnos.local','hash_alumno',3),
('Yahir','Reyna','yahir.reyna@alumnos.local','hash_alumno',3),
('Aimee','Cruz','aimee.cruz@alumnos.local','hash_alumno',3),
('Lisandro','Torres','lisandro.torres@alumnos.local','hash_alumno',3),
('Fiona','Noriega','fiona.noriega@alumnos.local','hash_alumno',3),
('Joel','Sánchez','joel.sanchez@alumnos.local','hash_alumno',3),
('Cintia','Rito','cintia.rito@alumnos.local','hash_alumno',3),
('Noa','Méndez','noa.mendez@alumnos.local','hash_alumno',3),
('Bruno','Paredes','bruno.paredes@alumnos.local','hash_alumno',3),
('Ariel','Miranda','ariel.miranda@alumnos.local','hash_alumno',3),
('Marcos','Gutiérrez','marcos.gutierrez@alumnos.local','hash_alumno',3),
('Lorenzo','Suárez','lorenzo.suarez@alumnos.local','hash_alumno',3),
('Dana','Paz','dana.paz@alumnos.local','hash_alumno',3),
('Víctor','Serrano','victor.serrano@alumnos.local','hash_alumno',3),
('Amanda','López','amanda.lopez@alumnos.local','hash_alumno',3),
('Mauro','Cáceres','mauro.caceres@alumnos.local','hash_alumno',3),
('Elena','Quiroz','elena.quiroz@alumnos.local','hash_alumno',3),
('Thiago','Sosa','thiago.sosa@alumnos.local','hash_alumno',3),
('Nadia','Uribe','nadia.uribe@alumnos.local','hash_alumno',3),
('Pablo','Gallegos','pablo.gallegos@alumnos.local','hash_alumno',3),
('Julieta','Sánchez','julieta.sanchez@alumnos.local','hash_alumno',3),
('Mauricio','Ramos','mauricio.ramos@alumnos.local','hash_alumno',3),
('Diana','Cervantes','diana.cervantes@alumnos.local','hash_alumno',3),
('Félix','Guzmán','felix.guzman@alumnos.local','hash_alumno',3),
('Regina','Soto','regina.soto@alumnos.local','hash_alumno',3),
('Alan','Muñoz','alan.munoz@alumnos.local','hash_alumno',3),
('María','Suárez','maria.suarez2@alumnos.local','hash_alumno',3),
('Paolo','Barrera','paolo.barrera@alumnos.local','hash_alumno',3),
('Carlota','Márquez','carlota.marquez@alumnos.local','hash_alumno',3),
('Germán','Haro','german.haro@alumnos.local','hash_alumno',3),
('Marta','Pérez','marta.perez2@alumnos.local','hash_alumno',3),
('Iván','Galván','ivan.galvan@alumnos.local','hash_alumno',3),
('María','Ruiz','maria.ruiz@alumnos.local','hash_alumno',3),
('Silvia','Román','silvia.roman@alumnos.local','hash_alumno',3),
('Galo','Hernández','galo.hernandez@alumnos.local','hash_alumno',3),
('Magdalena','Ortega','magdalena.ortega@alumnos.local','hash_alumno',3),
('Hans','López','hans.lopez@alumnos.local','hash_alumno',3),
('Yasmin','Vega','yasmin.vega@alumnos.local','hash_alumno',3),
('Braulio','Cabrera','braulio.cabrera@alumnos.local','hash_alumno',3),
('Rocío','Varela','rocio.varela@alumnos.local','hash_alumno',3),
('Ximena','Paz','ximena.paz2@alumnos.local','hash_alumno',3),
('Alan','González','alan.gonzalez@alumnos.local','hash_alumno',3),
('Ariadna','Cervantes','ariadna.cervantes2@alumnos.local','hash_alumno',3),
('Marcel','Sosa','marcel.sosa@alumnos.local','hash_alumno',3),
('Kenia','Valdez','kenia.valdez@alumnos.local','hash_alumno',3),
('Iván','Perales','ivan.perales@alumnos.local','hash_alumno',3),
('María','Lugo','maria.lugo@alumnos.local','hash_alumno',3),
('Renata','Marín','renata.marin@alumnos.local','hash_alumno',3),
('Humberto','Sánchez','humberto.sanchez@alumnos.local','hash_alumno',3),
('Flora','Ramos','flora.ramos@alumnos.local','hash_alumno',3),
('Ariel','Pacheco','ariel.pacheco@alumnos.local','hash_alumno',3),
('Carolina','Torres','carolina.torres@alumnos.local','hash_alumno',3),
('Rogelio','Mata','rogelio.mata@alumnos.local','hash_alumno',3),
('Aitana','Bravo','aitana.bravo@alumnos.local','hash_alumno',3),
('Sebastián','Prieto','sebastian.prieto@alumnos.local','hash_alumno',3),
('Valentina','Oliva','valentina.oliva@alumnos.local','hash_alumno',3),
('Nicolás','Varela','nicolas.varela@alumnos.local','hash_alumno',3),
('Gala','Molina','gala.molina2@alumnos.local','hash_alumno',3),
('Thiago','Pineda','thiago.pineda@alumnos.local','hash_alumno',3),
('Noemí','Gutiérrez','noemi.gutierrez@alumnos.local','hash_alumno',3),
('Daniel','Vargas','daniel.vargas2@alumnos.local','hash_alumno',3),
('Adriana','Cárdenas','adriana.cardenas@alumnos.local','hash_alumno',3),
('Rafael','Quintero','rafael.quintero@alumnos.local','hash_alumno',3),
('Emilia','Bravo','emilia.bravo@alumnos.local','hash_alumno',3),
('Brais','Soler','brais.soler@alumnos.local','hash_alumno',3),
('Ainhoa','Vargas','ainhoa.vargas@alumnos.local','hash_alumno',3),
('Luz','Márquez','luz.marquez@alumnos.local','hash_alumno',3),
('Raúl','Serrano','raul.serrano2@alumnos.local','hash_alumno',3),
('Iván','Ortiz','ivan.ortiz2@alumnos.local','hash_alumno',3),
('Nayeli','García','nayeli.garcia@alumnos.local','hash_alumno',3),
('Diego','Sánchez','diego.sanchez2@alumnos.local','hash_alumno',3),
('Gonzalo','Herrera','gonzalo.herrera@alumnos.local','hash_alumno',3),
('Lidia','Suárez','lidia.suarez2@alumnos.local','hash_alumno',3),
('Ismael','Vega','ismael.vega@alumnos.local','hash_alumno',3),
('Candela','Paz','candela.paz@alumnos.local','hash_alumno',3),
('Joel','Gama','joel.gama@alumnos.local','hash_alumno',3),
('Kiara','Montes','kiara.montes@alumnos.local','hash_alumno',3),
('Eloy','Cruz','eloy.cruz@alumnos.local','hash_alumno',3),
('Brenda','Lara','brenda.lara2@alumnos.local','hash_alumno',3),
('Félix','Bravo','felix.bravo@alumnos.local','hash_alumno',3),
('Renata','Castillo','renata.castillo@alumnos.local','hash_alumno',3),
('Elías','Paz','elias.paz@alumnos.local','hash_alumno',3),
('Lorena','Giménez','lorena.gimenez@alumnos.local','hash_alumno',3),
('Ciro','Vargas','ciro.vargas2@alumnos.local','hash_alumno',3),
('Marina','Delgado','marina.delgado@alumnos.local','hash_alumno',3),
('Bastián','Ortiz','bastian.ortiz@alumnos.local','hash_alumno',3),
('Gala','Márquez','gala.marquez@alumnos.local','hash_alumno',3),
('Rocinante','Montaño','rocinante.montano@alumnos.local','hash_alumno',3),
('Noelia','Soria','noelia.soria@alumnos.local','hash_alumno',3),
('Miren','Ugalde','miren.ugalde@alumnos.local','hash_alumno',3),
('Omar','Santos','omar.santos2@alumnos.local','hash_alumno',3),
('César','Vásquez','cesar.vasquez@alumnos.local','hash_alumno',3),
('Renzo','Quintana','renzo.quintana@alumnos.local','hash_alumno',3),
('Isabel','Vega','isabel.vega2@alumnos.local','hash_alumno',3),
('Gustavo','Núñez','gustavo.nunez@alumnos.local','hash_alumno',3),
('Maribel','Santos','maribel.santos@alumnos.local','hash_alumno',3),
('Enrique','Bustos','enrique.bustos@alumnos.local','hash_alumno',3),
('Leticia','Reyes','leticia.reyes@alumnos.local','hash_alumno',3),
('Mauro','Paz','mauro.paz@alumnos.local','hash_alumno',3),
('Elvira','García','elvira.garcia@alumnos.local','hash_alumno',3),
('Rafael','Méndez','rafael.mendez@alumnos.local','hash_alumno',3),
('Diana','Suárez','diana.suarez3@alumnos.local','hash_alumno',3),
('Joaquín','Campos','joaquin.campos2@alumnos.local','hash_alumno',3),
('Luz','Vargas','luz.vargas2@alumnos.local','hash_alumno',3),
('Bruno','Molina','bruno.molina@alumnos.local','hash_alumno',3),
('Celia','Pérez','celia.perez@alumnos.local','hash_alumno',3),
('Manuel','Soria','manuel.soria2@alumnos.local','hash_alumno',3),
('Valeria','Ibarra','valeria.ibarra@alumnos.local','hash_alumno',3),
('Nayra','Hernández','nayra.hernandez@alumnos.local','hash_alumno',3),
('Isaac','Ramírez','isaac.ramirez@alumnos.local','hash_alumno',3),
('Violeta','Bravo','violeta.bravo@alumnos.local','hash_alumno',3),
('Tomas','Luna','tomas.luna@alumnos.local','hash_alumno',3),
('Iris','Paz','iris.paz@alumnos.local','hash_alumno',3),
('César','Arias','cesar.arias2@alumnos.local','hash_alumno',3),
('Gina','Peña','gina.pena@alumnos.local','hash_alumno',3),
('Héctor','Gómez','hector.gomez2@alumnos.local','hash_alumno',3),
('Laura','Ortega','laura.ortega2@alumnos.local','hash_alumno',3),
('Saúl','Aguirre','saul.aguirre@alumnos.local','hash_alumno',3),
('Federico','Ríos','federico.rios@alumnos.local','hash_alumno',3),
('Rosa','Olvera','rosa.olvera@alumnos.local','hash_alumno',3),
('Dalia','Mendoza','dalia.mendoza@alumnos.local','hash_alumno',3),
('Eder','González','eder.gonzalez@alumnos.local','hash_alumno',3),
('Yasmin','Pineda','yasmin.pineda2@alumnos.local','hash_alumno',3),
('Lourdes','Gómez','lourdes.gomez2@alumnos.local','hash_alumno',3);


-- Administradores: vincular el usuario admin insertado anteriormente
INSERT INTO Administradores (id_usuario)
SELECT id FROM Usuarios WHERE email = 'admin@escuela.mx';

-- Profesores: insertar todos los usuarios con id_rol = 2
INSERT INTO Profesores (id_usuario)
SELECT id FROM Usuarios WHERE id_rol = 2 ORDER BY id;

-- Padres: insertar todos los usuarios con id_rol = 4
INSERT INTO Padres (id_usuario)
SELECT id FROM Usuarios WHERE id_rol = 4 ORDER BY id;

-- Alumnos: insertar todos los usuarios con id_rol = 3 (id_padre lo asignaremos después)
INSERT INTO Alumnos (id_usuario)
SELECT id FROM Usuarios WHERE id_rol = 3 ORDER BY id;


-- ========== ASIGNATURAS (8) ==========
INSERT INTO Asignaturas (nombre) VALUES
                                     ('Matemáticas'),
                                     ('Español'),
                                     ('Historia'),
                                     ('Geografía'),
                                     ('Biología'),
                                     ('Física'),
                                     ('Inglés'),
                                     ('Computación');

-- ========== GRUPOS (12) ==========
-- Asignación: tomamos las asignaturas por nombre y asignamos profesores por orden (los primeros profesores)
-- Ajusta OFFSETs si quieres repartir distinto.

INSERT INTO Grupos (id_asignatura, id_profesor, nombre) VALUES
                                                            (
                                                                (SELECT id FROM Asignaturas WHERE nombre='Matemáticas' LIMIT 1),
                                                            (SELECT id FROM Profesores ORDER BY id LIMIT 1),
    'MAT-101 A'
    ),
(
  (SELECT id FROM Asignaturas WHERE nombre='Matemáticas' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 1),
  'MAT-101 B'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Español' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 2),
  'ESP-201 A'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Español' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 3),
  'ESP-201 B'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Historia' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 4),
  'HIS-301'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Geografía' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 5),
  'GEO-302'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Biología' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 6),
  'BIO-401'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Física' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 7),
  'FIS-402'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Inglés' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 8),
  'ING-501'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Computación' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 9),
  'COMP-601'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Computación' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 10),
  'COMP-602'
),
(
  (SELECT id FROM Asignaturas WHERE nombre='Inglés' LIMIT 1),
  (SELECT id FROM Profesores ORDER BY id LIMIT 1 OFFSET 11),
  'ING-502'
);

-- ========== ASIGNAR PADRES A ALUMNOS  ==========
-- Estrategia: cada alumno recibe un padre en round-robin sobre el conjunto de Padres.
-- Padres.id empieza en 1, Alumnos.id también. Usamos el COUNT de Padres.

-- 1) Obtener cantidad de padres (variable)
SET @padres_count = (SELECT COUNT(*) FROM Padres);

-- 2) Actualizar Alumnos.id_padre asignando: ((Alumnos.id - 1) % @padres_count) + 1
UPDATE Alumnos
SET id_padre = ((id - 1) % @padres_count) + 1;

-- Esto asocia padres 1..@padres_count a los alumnos en orden, rotando.

-- ========== INSCRIPCIONES (cada alumno en ~4 grupos) ==========
-- Estrategia: para cada alumno a y cada grupo g, insertamos cuando (a.id + g.id) % 12 < 4
-- Esto produce aproximadamente 4 grupos por alumno (dependiendo del módulo).

INSERT INTO Inscripciones (id_alumno, id_grupo, calificacion)
SELECT a.id, g.id, ROUND(60 + RAND() * 40, 2)
FROM Alumnos a
         JOIN Grupos g ON ((a.id + g.id) % 12) < 4;


-- ========== ASISTENCIAS (5 por inscripción, fechas distribuidas) ==========
-- Estrategia: Para cada inscripción i, generamos 5 registros de asistencia con fechas calculadas:
-- fecha = DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + offset) % 81) DAY)
-- (rango 2025-01-10 .. 2025-03-31 -> 81 días)

-- Offset = 0..4 -> 5 registros por inscripción
INSERT INTO Asistencias (id_alumno, id_grupo, fecha)
SELECT i.id_alumno, i.id_grupo, DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + 0) % 81) DAY)
FROM Inscripciones i;

INSERT INTO Asistencias (id_alumno, id_grupo, fecha)
SELECT i.id_alumno, i.id_grupo, DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + 1) % 81) DAY)
FROM Inscripciones i;

INSERT INTO Asistencias (id_alumno, id_grupo, fecha)
SELECT i.id_alumno, i.id_grupo, DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + 2) % 81) DAY)
FROM Inscripciones i;

INSERT INTO Asistencias (id_alumno, id_grupo, fecha)
SELECT i.id_alumno, i.id_grupo, DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + 3) % 81) DAY)
FROM Inscripciones i;

INSERT INTO Asistencias (id_alumno, id_grupo, fecha)
SELECT i.id_alumno, i.id_grupo, DATE_ADD('2025-01-10', INTERVAL ((i.id * 7 + 4) % 81) DAY)
FROM Inscripciones i;