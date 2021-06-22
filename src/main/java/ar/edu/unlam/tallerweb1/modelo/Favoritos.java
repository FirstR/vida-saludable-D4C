package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "favoritos")

public class Favoritos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long favorito_id;

        @ManyToOne
        @JoinColumn(name = "id_plato")
        private Plato plato;

        private Long id_usuario;

        public Favoritos(Long id_usuario, Plato plato) {
                this.id_usuario = id_usuario;
                this.plato = plato;
        }

        public Favoritos() {

        }

        public Long getFavorito_id() {
                return favorito_id;
        }

        public void setFavorito_id(Long favorito_id) {
                this.favorito_id = favorito_id;
        }

        public Plato getPlato() {
                return plato;
        }

        public void setPlato(Plato plato) {
                this.plato = plato;
        }

        public Long getId_usuario() {
                return id_usuario;
        }

        public void setId_usuario(Long id_usuario) {
                this.id_usuario = id_usuario;
        }
}
