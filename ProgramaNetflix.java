
public class ProgramaNetflix {

	private String id;
	private String titulo;
	private String show_type;
	private String descricao;
	private int release_year;
	private String age_certification;
	private float runtime;
	private String[] generos;
	private String[] production_countries;
	private float temporadas;
	private String imdb_id;
	private float imdb_score;
	private float imdb_votes;
	private float tmdb_popularity;
	private float tmdb_score;

	public ProgramaNetflix() {
		id = "no-id";
		titulo = "no-titulo";
		show_type = "no-show_type";
		descricao = "no-descricao";
		release_year = 0;
		age_certification = "no-age_certification";
		runtime = 0;
		//generos = ;
		//production_countries = ;
		temporadas = 0;
		imdb_id = "no-imdb_id";
		imdb_score = 0;
		imdb_votes = 0;
		tmdb_popularity = 0;
		tmdb_score = 0;
	}
	
	public ProgramaNetflix(String id, String titulo, String show_type, String descricao, int release_year, String age_certification, float runtime, String[] generos, String[] production_countries, float temporadas, String imdb_id, float imdb_score, float imdb_votes, float tmdb_popularity, float tmdb_score ) {
		this.id = id;
		this.titulo = titulo;
		this.show_type = show_type;
		this.descricao = descricao;
		this.release_year = release_year;
		this.age_certification = age_certification;
		this.runtime = runtime;
		this.generos = generos;
		this.production_countries = production_countries;
		this.temporadas = temporadas;
		this.imdb_id = imdb_id;
		this.imdb_score = imdb_score;
		this.imdb_votes = imdb_votes;
		this.tmdb_popularity = tmdb_popularity;
		this.tmdb_score = tmdb_score;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getShow_type() {
		return show_type;
	}
	
	public void setShow_type(String show_type) {
		this.show_type = show_type;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getRelease_year() {
		return release_year;
	}
	
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	
	public String getAge_certification() {
		return age_certification;
	}
	
	public void setAge_certification(String age_certification) {
		this.age_certification = age_certification;
	}
	
	public float getRuntime() {
		return runtime;
	}
	
	public void setRuntime(float runtime) {
		this.runtime = runtime;
	}
	
	public String[] getGeneros() {
		return generos;
	}
	
	public void setGeneros(String[] generos) {
		this.generos = generos;
	}
	
	public String[] getProduction_countries() {
		return production_countries;
	}
	
	public void setProduction_countries(String[] production_countries) {
		this.production_countries = production_countries;
	}
	
	public float getTemporadas() {
		return temporadas;
	}
	
	public void setTemporadas(float temporadas) {
		this.temporadas = temporadas;
	}
	
	public String getImdb_id() {
		return imdb_id;
	}
	
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	
	public float getImdb_score() {
		return imdb_score;
	}
	
	public void setImdb_score(float imdb_score) {
		this.imdb_score = imdb_score;
	}
	
	public float getImdb_votes() {
		return imdb_votes;
	}
	
	public void setImdb_votes(float imdb_votes) {
		this.imdb_votes = imdb_votes;
	}
	
	public float getTmdb_popularity() {
		return tmdb_popularity;
	}
	
	public void setTmdb_popularity(float tmdb_popularity) {
		this.tmdb_popularity =  tmdb_popularity;
	}
	
	public float getTmdb_score() {
		return tmdb_score;
	}
	
	public void setTmdb_score(float tmdb_score) {
		this.tmdb_score = tmdb_score;
	}
}
