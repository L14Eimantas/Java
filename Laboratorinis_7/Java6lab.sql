USE [Java6lab]
GO
/****** Object:  Table [dbo].[Grupe]    Script Date: 13/11/2015 10:03:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Grupe](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kodas] [varchar](50) NOT NULL,
	[studprog] [varchar](50) NOT NULL,
	[metai] [int] NOT NULL,
 CONSTRAINT [PK_Grupe] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ivertinimas]    Script Date: 13/11/2015 10:03:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ivertinimas](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[nrstud] [int] NOT NULL,
	[data] [varchar](50) NOT NULL,
	[pazimys] [int] NOT NULL,
	[aprasymas] [varchar](80) NULL,
 CONSTRAINT [PK_Ivertinimas] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Studentas]    Script Date: 13/11/2015 10:03:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Studentas](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[grupe] [varchar](50) NOT NULL,
	[grupesnr] [int] NOT NULL,
	[vardas] [varchar](50) NOT NULL,
	[pavarde] [varchar](50) NOT NULL,
	[studnr] [int] NOT NULL,
 CONSTRAINT [PK_Studentas] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Ivertinimas]  WITH CHECK ADD  CONSTRAINT [FK_Ivertinimas_Studentas] FOREIGN KEY([nrstud])
REFERENCES [dbo].[Studentas] ([Id])
GO
ALTER TABLE [dbo].[Ivertinimas] CHECK CONSTRAINT [FK_Ivertinimas_Studentas]
GO
ALTER TABLE [dbo].[Studentas]  WITH CHECK ADD  CONSTRAINT [FK_Studentas_Grupe] FOREIGN KEY([grupesnr])
REFERENCES [dbo].[Grupe] ([Id])
GO
ALTER TABLE [dbo].[Studentas] CHECK CONSTRAINT [FK_Studentas_Grupe]
GO
