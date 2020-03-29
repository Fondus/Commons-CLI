package tw.fondus.commons.cli.argument;

/**
 *
 *
 * @author Brad Chen
 * @since 0.3.0
 */
public interface IHelpArgument {
	/**
	 * Is help or not.
	 *
	 * @return help state
	 */
	boolean isHelp();

	/**
	 * Set help state.
	 *
	 * @param help help state
	 */
	void setHelp( boolean help );
}
