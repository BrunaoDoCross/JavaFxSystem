package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Usuario;

public class UsuarioJsonUtil {
    private static final String FILE_PATH = "usuarios.json";

    public static void persistirUsuario(Usuario usuario) {
        List<Usuario> usuarios = carregarUsuarios();
        usuarios.add(usuario);
        salvarUsuarios(usuarios);
    }

    public static void removerUsuario(String login) {
        List<Usuario> usuarios = carregarUsuarios();
        boolean usuarioRemovido = false;

        login = CriptografiaAES.criptografar(login);

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuarios.remove(usuario);
                usuarioRemovido = true;
                break;
            }
        }
        if (usuarioRemovido) {
            salvarUsuarios(usuarios);
        }
    }

    public static List<Usuario> carregarUsuarios() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(FILE_PATH)) {
            Usuario[] usuariosArray = gson.fromJson(reader, Usuario[].class);
            List<Usuario> usuarios = new ArrayList<>();
            if (usuariosArray != null) {
                for (Usuario usuario : usuariosArray) {
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários do JSON: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    private static void salvarUsuarios(List<Usuario> usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários no JSON: " + e.getMessage());
        }
    }
}