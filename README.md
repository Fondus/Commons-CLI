# Commons-CLI
The standard commons interface of FondUS to write command-line program base on JCommander and zt-exec.

- The JRE flavor requires **JDK 1.8** or higher.

## The Standard Arguments
- `BasicArguments`: If you **don't need the input/output files list**, use this please.

| Argument | Description | Default | Required |
|:------ |:----------- |:-----------:|:-----------:|
| -b / --base | The current working directory. | - | true |
| -h / --help | Show how to usage. | - | false |
| -id / --idir | The input file folder, relative to the current working directory. | Input/ | false |
| -od / --odir | The output file folder, relative to the current working directory. | Output/ | false |

- `ConfigArguments`: If you **need read congih/properties**, use this please.

| Argument | Description | Default | Required |
|:------ |:----------- |:-----------:|:-----------:|
| -c / --config | The file name of configuration, relative to the current working directory. | - | true |

## Dependencies
- [JCommander](https://github.com/cbeust/jcommander)
- [zt-exec](https://github.com/zeroturnaround/zt-exec)

## License
- The Commons-CLI Library are licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

## Authors and Contributors
The Commons-Java libraries are developed by the FondUS Technology Co., Ltd. and are maintained by [@Vipcube](https://github.com/Vipcube).
