create database hist_peso;

use hist_peso;

create table historico(
id int not null auto_increment primary key,
dataCadastro date,
peso double not null
)
