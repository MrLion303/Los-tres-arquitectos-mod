# Los Tres Arquitectos

Mod para Minecraft Java 1.20.1 con Forge 47.4.x. Añade tres partículas decorativas inspiradas visualmente en las luces de DOORS y tres bloques invisibles emisores.

## Partículas
```mcfunction
/particle architects:moonlight ~ ~1 ~
/particle architects:strlight ~ ~1 ~
/particle architects:red_architect ~ ~1 ~
```
El ID `architects:strlight` conserva la grafía solicitada; el nombre que aparece en el juego es Starlight.

## Bloques
Los emisores de Moonlight, Starlight y Arquitecto Rojo no tienen colisión y son invisibles, pero conservan una caja de selección para retirarlos fácilmente. Sus objetos muestran un icono y aparecen en la pestaña Bloques funcionales del modo creativo.

## Gráficos mínimos
Los tipos se registran con `overrideLimiter=true` para intentar evitar el limitador normal de partículas. No puede garantizarse visibilidad frente a límites internos del motor, mods de rendimiento o configuraciones externas del cliente.

## Compilar
El flujo de GitHub Actions **Compilar el mod** ejecuta Gradle 8.8 con Java 17 y guarda el JAR como artefacto. También se puede compilar con `gradle build`.

Efectos visuales creados para este mod; DOORS y sus personajes pertenecen a sus respectivos titulares.
